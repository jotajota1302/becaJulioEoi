package com.eoi.es.springwebdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eoi.es.springwebdemo.dto.BookDto;
import com.eoi.es.springwebdemo.entity.Book;
import com.eoi.es.springwebdemo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<BookDto> findAll() {

		List<BookDto> resultado = new ArrayList<BookDto>();

		List<Book> lista = bookRepository.findAll();

		for (Book book : lista) {

			resultado.add(new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getGenre()));

		}

		return resultado;

	}
	
	public List<BookDto> findAll(Pageable pageable) {

		List<BookDto> resultado = new ArrayList<BookDto>();

		Page<Book> lista = bookRepository.findAll(pageable);

		for (Book book : lista) {

			resultado.add(new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getGenre()));

		}

		return resultado;

	}
}
