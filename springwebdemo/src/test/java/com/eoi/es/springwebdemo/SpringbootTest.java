package com.eoi.es.springwebdemo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eoi.es.springwebdemo.entity.Book;
import com.eoi.es.springwebdemo.repository.BookRepository;

@SpringBootTest
public class SpringbootTest {

	
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void test() {
		
		//SELECTS
		System.out.println(bookRepository.findAll());
		System.out.println(bookRepository.findById(3).get());	
		
		//INSERTS
		
		Book nuevo= Book.builder().author("JK Rowling").genre("Fantastico").title("HARRY FLOWERS").build();
//		bookRepository.save(nuevo);
		
		System.out.println(bookRepository.findAll());		
		
		//UPDATE == SAVE de una entidad que ya tiene ID	
		
		//DELETE
		
//		bookRepository.delete(nuevo);
		bookRepository.deleteById(6);
		
	}
}
