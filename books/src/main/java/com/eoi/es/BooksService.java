package com.eoi.es;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
	
	@Autowired
	AuthorClient authorClient;
	
	@Autowired
	private BooksRepository booksRepository;

	public List<BookDto> findAll() {

		List<BookDto> dtos = new ArrayList<BookDto>();
		List<Book> entities = booksRepository.findAll();
		for (Book book : entities) {
			dtos.add(entityToDto(book));
		}

		return dtos;
	}

	public BookDto findById(Integer id) {

		return entityToDto(booksRepository.findById(id).get());

	}

	public BookWithAuthorDto findByIdWithAuthor(Integer id){		
		
		BookDto dto = entityToDto(booksRepository.findById(id).get());		
		BookWithAuthorDto bookWithAuthorDto= new BookWithAuthorDto();
		BeanUtils.copyProperties(dto, bookWithAuthorDto);
		
		try {
		
			bookWithAuthorDto.setAuthor(authorClient.getAuthorById(id));
			
		} catch (Exception e) {
			dto.setAuthor(null);
		}
		
		return bookWithAuthorDto;		
		
		
	}

	public List<BookDto> findByAuthorId(Integer id) {

		List<BookDto> dtos = new ArrayList<BookDto>();
		List<Book> lista = booksRepository.findByAuthor(id);

		for (Book book : lista) {
			dtos.add(entityToDto(book));
		}

		return dtos;
	}

	public void create(BookDto dto) {

		Book entity = dtoToEntity(dto);
		entity.setId(null);

		booksRepository.save(entity);

	}

	public void update(BookDto dto) {

		Book entity = dtoToEntity(dto);

		booksRepository.save(entity);

	}

	public void deleteById(Integer id) {

		booksRepository.deleteById(id);
	}

	private BookDto entityToDto(Book book) {

		BookDto dto = new BookDto();
		dto.setId(book.getId());
		dto.setTitle(book.getTitle());
		dto.setAuthor(book.getAuthor());

		return dto;
	}

	private Book dtoToEntity(BookDto dto) {

		Book book = new Book();
		book.setId(dto.getId());
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());

		return book;
	}
}
