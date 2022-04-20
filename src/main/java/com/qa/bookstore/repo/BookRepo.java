package com.qa.bookstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.bookstore.domain.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

	List<Book> findByTitleIgnoreCase(String title);
	List<Book> findByAuthorIgnoreCase(String author);
	List<Book> findByGenreIgnoreCase(String genre);
	List<Book> findByPublicationYear(Integer publicationYear);
}
