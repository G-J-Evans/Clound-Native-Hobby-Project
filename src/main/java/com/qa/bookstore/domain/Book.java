package com.qa.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column(nullable = false)
		private String title;
		
		@Column(nullable = false)
		private String author;
		
		@Column
		private String genre;
		
		@Column
		private Integer publicationYear;

		public Book() {
			super();
		}
		public Book(Integer id, String title, String author, String genre, Integer publicationYear) {
			super();
			this.id = id;
			this.title = title;
			this.author = author;
			this.genre = genre;
			this.publicationYear = publicationYear;
		}
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String name) {
			this.title = name;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public Integer getPublicationYear() {
			return publicationYear;
		}
		public void setPublicationYear(Integer publicationYear) {
			this.publicationYear = publicationYear;
		}
		
		@Override
		public String toString() {
			return "Book [id=" + id + ", name=" + title + ", author=" + author + ", genre=" + genre
					+ ", publicationYear=" + publicationYear + "]";
		}
}
