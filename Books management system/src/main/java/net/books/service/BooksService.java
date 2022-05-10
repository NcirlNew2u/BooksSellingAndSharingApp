package net.books.service;

import java.util.List;

import net.books.entity.Books;

public interface BooksService {
	List<Books> getAllBook(String keyword);
	
	Books saveBook(Books books);
	
	Books getBookById(Long id);
	
	Books updateBook(Books books);
	
	void deleteBookById(Long id);
}
