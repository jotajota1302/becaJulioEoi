package com.eoi.es.springwebdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eoi.es.springwebdemo.entity.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {
	
}
