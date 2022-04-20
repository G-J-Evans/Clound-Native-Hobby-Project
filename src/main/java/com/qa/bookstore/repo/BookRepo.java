package com.qa.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.bookstore.domain.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}
