package com.qa.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.bookstore.domain.Book;
import com.qa.bookstore.service.BookService;

@RestController
public class BookController {
	private BookService service;
	
	@Autowired
	public BookController(BookService service) {
		super();
		this.service = service;
	}
	
	// create / 201 - CREATED
	@PostMapping("/create")
	public ResponseEntity<Book> createDog(@RequestBody Book book) {
		return new ResponseEntity<>(this.service.create(book), HttpStatus.CREATED);
	}
	
	
	//read all / 200 - OK
	@GetMapping("/getAll") 
	public ResponseEntity<List<Book>>  getAll() {
			return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
	}
	
	//read one by id / 200 - OK
	@GetMapping("/get/{id}")
	public ResponseEntity<Book> getOne(@PathVariable Integer id) {
			return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
	}
	
	//update / 202 - ACCEPTED
	@PutMapping("/replace/{id}") 
	public ResponseEntity<Book> replace(@PathVariable Integer id, @RequestBody Book book) {
			return new ResponseEntity<>(this.service.replace(id,book), HttpStatus.ACCEPTED);
	}
	
	//delete / 204 - NO CONTENT
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
			this.service.remove(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// read by author / 200 -OK
	@GetMapping("/author/{author}") 
	public ResponseEntity<List<Book>> getByAuthor(@PathVariable String author) {
		return new ResponseEntity<>(this.service.getByAuthor(author), HttpStatus.OK);
	}
	
	// read by author / 200 -OK
	@GetMapping("/title/{title}") 
	public ResponseEntity<List<Book>> getByTitle(@PathVariable String title) {
		return new ResponseEntity<>(this.service.getByTitle(title), HttpStatus.OK);
	}
	
	// read by author / 200 -OK
	@GetMapping("/genre/{genre}") 
	public ResponseEntity<List<Book>> getByGenre(@PathVariable String genre) {
		return new ResponseEntity<>(this.service.getByGenre(genre), HttpStatus.OK);
	}
	
	// read by author / 200 -OK
	@GetMapping("/year/{publicationYear}") 
	public ResponseEntity<List<Book>> getByPublicationYear(@PathVariable Integer publicationYear) {
		return new ResponseEntity<>(this.service.getByPublicationYear(publicationYear), HttpStatus.OK);
	}
}
