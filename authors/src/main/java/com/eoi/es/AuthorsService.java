package com.eoi.es;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthorsService {

	private static final String BOOKS_SERVICE_URL = "http://localhost:8082/books/author/";

	@Autowired
	private AuthorsRepository authorsRepository;

	public List<AuthorDto> findAll() {

		List<AuthorDto> dtos = new ArrayList<AuthorDto>();
		List<Author> entities = authorsRepository.findAll();
		for (Author author : entities) {
			dtos.add(entityToDto(author));
		}

		return dtos;
	}

	public AuthorDto findById(Integer id) {

		Author author = authorsRepository.findById(id).get();

		AuthorDto dto = entityToDto(author);

		try {
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<List<BookDto>> booksResponse = restTemplate.exchange(
					BOOKS_SERVICE_URL.concat(author.getId() + ""), HttpMethod.GET, null,
					new ParameterizedTypeReference<List<BookDto>>() {
					});
			dto.setBooks(booksResponse.getBody());

		} catch (Exception e) {
			dto.setBooks(null);
		}		

		return dto;
	}

	public void create(AuthorDto dto) {

		Author entity = dtoToEntity(dto);
		entity.setId(null);

		authorsRepository.save(entity);

	}

	public void update(AuthorDto dto) {

		Author entity = dtoToEntity(dto);

		authorsRepository.save(entity);

	}

	public void deleteById(Integer id) {

		authorsRepository.deleteById(id);
	}

	private AuthorDto entityToDto(Author author) {

		AuthorDto dto = new AuthorDto();
		dto.setId(author.getId());
		dto.setSurname(author.getSurname());
		dto.setName(author.getName());

		return dto;
	}

	private Author dtoToEntity(AuthorDto dto) {

		Author author = new Author();
		author.setId(dto.getId());
		author.setSurname(dto.getSurname());
		author.setName(dto.getName());

		return author;
	}
}
