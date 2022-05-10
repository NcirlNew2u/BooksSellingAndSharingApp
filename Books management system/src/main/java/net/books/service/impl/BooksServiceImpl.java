package net.books.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.books.entity.Books;
import net.books.repository.BooksRepository;
import net.books.service.BooksService;

@Service
public class BooksServiceImpl implements BooksService{

	private BooksRepository booksRepository;
	
	public BooksServiceImpl(BooksRepository booksRepository) {
		super();
		this.booksRepository = booksRepository;
	}

	@Override
	public List<Books> getAllBook(String keyword) {
		if(keyword !=null) {
			return booksRepository.findAll(keyword);
		}
			
		return booksRepository.findAll();
	}

	@Override
	public Books saveBook(Books books) {
		return booksRepository.save(books);
	}

	@Override
	public Books getBookById(Long id) {
		return booksRepository.findById(id).get();
	}

	@Override
	public Books updateBook(Books books) {
		return booksRepository.save(books);
	}

	@Override
	public void deleteBookById(Long id) {
		booksRepository.deleteById(id);	
	}

}
