package com.qa.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class BookController {
	
	private BookService service;
	
	@Autowired
	public BookController(BookService service) {
		super();
		this.service = service;
	}
	
	// create / 201 - CREATED
	@CrossOrigin
	@PostMapping("/create")
	public ResponseEntity<Book> createDog(@RequestBody Book book) {
		return new ResponseEntity<>(this.service.create(book), HttpStatus.CREATED);
	}
	
	
	//read all / 200 - OK
	@CrossOrigin
	@GetMapping("/getAll") 
	public ResponseEntity<List<Book>>  getAll() {
			return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
	}
	
	//read one by id / 200 - OK
	@CrossOrigin
	@GetMapping("/id/{id}")
	public ResponseEntity<Book> getOne(@PathVariable Integer id) {
			return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
	}
	
	// read by author / 200 - OK
	@CrossOrigin
	@GetMapping("/author/{author}") 
	public ResponseEntity<List<Book>> getAuthor(@PathVariable String author) {
		return new ResponseEntity<>(this.service.getAuthor(author), HttpStatus.OK);
	}
	
	// read by title / 200 - OK
	@CrossOrigin
	@GetMapping("/title/{title}") 
	public ResponseEntity<List<Book>> getTitle(@PathVariable String title) {
		return new ResponseEntity<>(this.service.getTitle(title), HttpStatus.OK);
	}
	
	// read by genre / 200 - OK
	@CrossOrigin
	@GetMapping("/genre/{genre}") 
	public ResponseEntity<List<Book>> getGenre(@PathVariable String genre) {
		return new ResponseEntity<>(this.service.getGenre(genre), HttpStatus.OK);
	}
	
	// read by publication year / 200 - OK
	@CrossOrigin
	@GetMapping("/year/{publicationYear}") 
	public ResponseEntity<List<Book>> getPublicationYear(@PathVariable Integer publicationYear) {
		return new ResponseEntity<>(this.service.getPublicationYear(publicationYear), HttpStatus.OK);
	}
	
	// read by random / 200 - OK
	@CrossOrigin
	@GetMapping("/random")
	public ResponseEntity<Book> getRandom() {
		return new ResponseEntity<>(this.service.getRandom(), HttpStatus.OK);
	}
	
	//update / 202 - ACCEPTED
	@CrossOrigin
	@PutMapping("/replace/{id}") 
	public ResponseEntity<Book> replace(@PathVariable Integer id, @RequestBody Book book) {
			return new ResponseEntity<>(this.service.replace(id,book), HttpStatus.ACCEPTED);
	}
	
	//delete / 204 - NO CONTENT
	@CrossOrigin
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
			this.service.remove(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
