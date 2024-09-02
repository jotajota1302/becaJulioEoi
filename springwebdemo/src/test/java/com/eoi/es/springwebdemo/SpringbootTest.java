package com.eoi.es.springwebdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eoi.es.springwebdemo.repository.BookRepository;

@SpringBootTest
public class SpringbootTest {

	
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void test() {
		
//		List<Book> list = bookRepository.findByGenreAndAuthor("Ficción", "Harper Lee");
//		
//		List<Book> list2 = bookRepository.findByTitleStartingWith("M");
//		
//		int total = bookRepository.countByTitleStartingWith("M");
//		
//		List<Book> list3 = bookRepository.findDistinctByGenre("Ficción");
//		
//		System.out.println(list3);
		
	}
}
