package com.qa.bookstore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.bookstore.domain.Book;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:book-schema.sql", "classpath:book-data.sql"}, executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class BookControllerIntergrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		// JSON to test
		String testBookJSON = this.mapper.writeValueAsString(new Book(null, "Knife", "Jo Nesbo", "Crime Thriller", 2019));
		// Request to test
		RequestBuilder request = post("/create").contentType(MediaType.APPLICATION_JSON).content(testBookJSON);
		// Expected JSON return
		String testCreatedBookJSON = this.mapper.writeValueAsString(new Book(2, "Knife", "Jo Nesbo", "Crime Thriller", 2019));
		
		// return we want
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedBookJSON);
		
		// The test
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetAll() throws Exception {
		RequestBuilder request = get("/getAll");
		
		List<Book> testBooks = List.of(new Book(1, "Fire", "Kristin Cashore", "Fantasy", 2009));
		
		String testBooksJSON = this.mapper.writeValueAsString(testBooks);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testBooksJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetOne() throws Exception {
		// Creates request for getOne (by id)
		RequestBuilder request = get("/get/1");
		
		// BookJSON to check against
		String testBookJSON = this.mapper.writeValueAsString(new Book(1, "Fire", "Kristin Cashore", "Fantasy", 2009));
		
		// return we want
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testBookJSON);
		
		// the check
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetAuthor() throws Exception {
		// Creates request for getAuthor
		RequestBuilder request = get("/author/Kristin Cashore");
		
		// BookJSON to check against
		String testBookJSON = this.mapper.writeValueAsString(List.of(new Book(1, "Fire", "Kristin Cashore", "Fantasy", 2009)));
		
		// return we want
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testBookJSON);
		
		// the check
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetTitle() throws Exception {
		// Creates request for getGenre
		RequestBuilder request = get("/title/Fire");
		
		// BookJSON to check against
		String testBookJSON = this.mapper.writeValueAsString(List.of(new Book(1, "Fire", "Kristin Cashore", "Fantasy", 2009)));
		
		// return we want
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testBookJSON);
		
		// the check
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetGenre() throws Exception {
		// Creates request for getGenre
		RequestBuilder request = get("/genre/Fantasy");
		
		// BookJSON to check against
		String testBookJSON = this.mapper.writeValueAsString(List.of(new Book(1, "Fire", "Kristin Cashore", "Fantasy", 2009)));
		
		// return we want
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testBookJSON);
		
		// the check
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testPublicationYear() throws Exception {
		// Creates request for getPublicationYear
		RequestBuilder request = get("/year/2009");
		
		// BookJSON to check against
		String testBookJSON = this.mapper.writeValueAsString(List.of(new Book(1, "Fire", "Kristin Cashore", "Fantasy", 2009)));
		
		// return we want
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testBookJSON);
		
		// the check
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testRandom() throws Exception {
		// Create request for get random
		RequestBuilder request = get("/random");
		
		// JSON to test
		String testBookJSON = this.mapper.writeValueAsString(new Book(1, "Fire", "Kristin Cashore", "Fantasy", 2009));

		// return we want 
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testBookJSON);
		
		// the check
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testReplace() throws Exception {
		// make BookJSON to replace with
		String testBookJSON = this.mapper.writeValueAsString(new Book(1, "Water", "Kristin", "Real", 2013));
		
		// creates request for update (by id)
		RequestBuilder request = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(testBookJSON);
		
		// return we want
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testBookJSON);
		
		// the check
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testRemove() throws Exception {
		// creates request for remove
		RequestBuilder request = delete("/remove/1");
		
		// return we want
		ResultMatcher checkStatus = status().isNoContent();
		
		// the check
		this.mvc.perform(request).andExpect(checkStatus);
	}
}
