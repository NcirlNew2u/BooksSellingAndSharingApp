package net.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.books.entity.Books;

public interface BooksRepository extends JpaRepository<Books, Long>{
	
	@Query("SELECT p FROM Books p WHERE p.title Like %?1%"
			+ "OR p.author LIKE %?1%"
			+ "OR p.price LIKE %?1%"
			+"OR p.description LIKE %?1%"
			+"OR p.PlaceAvaiable LIKE %?1%")
	public List<Books> findAll(String keyword);

}
