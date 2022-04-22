package com.qa.bookstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qa.bookstore.domain.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

	List<Book> findByTitleIgnoreCase(String title);
	List<Book> findByAuthorIgnoreCase(String author);
	List<Book> findByGenreIgnoreCase(String genre);
	List<Book> findByPublicationYear(Integer publicationYear);
	
	// For finding total number of values in the table
	Integer countBy();
	
	// Used for obtaining a random result
	@Query(value = "SELECT * FROM book ORDER BY id LIMIT :n, 1", nativeQuery = true)
	Book findNPlusOnethBookOrderByIdAsc(@Param("n") Integer n);
}