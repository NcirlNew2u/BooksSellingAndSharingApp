package net.books.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import net.books.entity.Books;
import net.books.entity.User;
import net.books.repository.BooksRepository;
import net.books.repository.UserRepository;
import net.books.service.BooksService;

@Controller
public class BooksController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BooksRepository bookRepo;
	
	private BooksService booksService;

	public BooksController(BooksService booksService) {
		super();
		this.booksService = booksService;
	}
	
	
	
	@GetMapping("/book")
	public String listBook(Model model, @Param("keyword") String keyword) {
		List<Books> books = booksService.getAllBook(keyword);
		model.addAttribute("book", books);
		model.addAttribute("keyword", keyword);
		return "book";
	}
	

	
	@GetMapping("/book/new")
	public String createBookForm(Model model) {
		List<User> listUser= userRepo.findAll();
		// create book object to
		Books books = new Books();
		model.addAttribute("book",new Books());
		model.addAttribute("listUser", listUser);
		return "create_book";
		
	}

	@PostMapping("/book")
	public String saveBook(@ModelAttribute(name="data") Books books, @RequestParam("fileImage") MultipartFile multipartFile)throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		books.setData(fileName);
		
		Books saveBook=bookRepo.save(books);
		String uploadDir="./Book-image"+ saveBook.getTitle();
		System.out.println(uploadDir);
		
		Path uploadPath = Paths.get(uploadDir);
			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
	
			try(InputStream inputStream = multipartFile.getInputStream()){
				Path filePath = uploadPath.resolve(fileName);
				System.out.println(filePath.toFile().getAbsolutePath());
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			}catch (IOException e) {
				throw new IOException("Could not save uploaded file: " +fileName);
			}
		return "redirect:/book";
	}
	
//Update the information in the database	
	
	@GetMapping("/book/edit/{id}")
	public String editBookForm(@PathVariable Long id, Model model) {
		model.addAttribute("book", booksService.getBookById(id));
		return "edit_book";
	}

	@PostMapping("/book/{id}")
	public String updateBook(@PathVariable Long id,
			@ModelAttribute("book") Books books,
			Model model) {
			
		// get book from database by id
		Books existingBook = booksService.getBookById(id);
		existingBook.setId(id);
		existingBook.setTitle(books.getTitle());
		existingBook.setAuthor(books.getAuthor());
		existingBook.setEdition(books.getEdition());
		existingBook.setDescription(books.getDescription());
		existingBook.setPrice(books.getPrice());
		existingBook.setPlaceAvaiable(books.getPlaceAvaiable());
		existingBook.setEmail(books.getEmail());
		existingBook.setData(books.getData());
		
		
// save updated student object
		booksService.updateBook(existingBook);
		return "redirect:/book";		
	}
	

	// handler method to handle delete student request
	
	@GetMapping("/book/{id}")
	public String deleteBook(@PathVariable Long id) {
		booksService.deleteBookById(id);
		return "redirect:/book";
	}
	
}
