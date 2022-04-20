package com.qa.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public Book create(Book book) {
		return this.repo.save(book);
	}

	@Override
	public List<Book> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Book getOne(Integer id) {
		return this.repo.findById(id).get();
	}

	@Override
	public Book replace(Integer id, Book newBook) {
		Book existing = this.repo.findById(id).get();
		existing.setTitle(newBook.getTitle());
		existing.setAuthor(newBook.getAuthor());
		existing.setGenre(newBook.getGenre());
		existing.setPublicationYear(newBook.getPublicationYear());
		return this.repo.save(existing);
	}

	@Override
	public void remove(Integer id) {
		this.repo.deleteById(id);
	}
}
