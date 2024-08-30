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
		
		System.out.println(bookRepository.findAll());
		
	}
}
