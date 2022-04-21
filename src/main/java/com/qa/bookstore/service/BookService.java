package com.qa.bookstore.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.qa.bookstore.domain.Book;
import com.qa.bookstore.repo.BookRepo;

@Service
public class BookService implements ServiceIF<Book>{

	private BookRepo repo;
	
	@Autowired
	public BookService(BookRepo repo) {
		super();
		this.repo = repo;
	}
	
	// Create
	@Override
	public Book create(Book book) {
		return this.repo.save(book);
	}

	// Read functions
	@Override
	public List<Book> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Book getOne(Integer id) {
		return this.repo.findById(id).get();
	}
	
	public List<Book> getTitle(String title) {
		return this.repo.findByTitleIgnoreCase(title);
	}
	
	public List<Book> getAuthor(String author) {
		return this.repo.findByAuthorIgnoreCase(author);
	}
	
	public List<Book> getGenre(String genre) {
		return this.repo.findByGenreIgnoreCase(genre);
	}
	
	public List<Book> getPublicationYear(Integer year) {
		return this.repo.findByPublicationYear(year);
	}
	
	public Book getRandom() {
		Integer noOfDogs = this.repo.countBy();
		if(noOfDogs == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Database has no entries");
		}
		return this.repo.findNPlusOnethBookOrderByIdAsc(new Random().nextInt(noOfDogs));
	}
	
	// Update
	@Override
	public Book replace(Integer id, Book newBook) {
		Book existing = this.repo.findById(id).get();
		existing.setTitle(newBook.getTitle());
		existing.setAuthor(newBook.getAuthor());
		existing.setGenre(newBook.getGenre());
		existing.setPublicationYear(newBook.getPublicationYear());
		return this.repo.save(existing);
	}

	// Delete
	@Override
	public void remove(Integer id) {
		this.repo.deleteById(id);
	}
}
