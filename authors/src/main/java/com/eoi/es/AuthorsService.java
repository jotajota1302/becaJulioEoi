package com.eoi.es;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorsService {

	@Autowired
	private AuthorsRepository authorsRepository;

	@Autowired
	private BookClient bookClient;

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

		return dto;
	}

	public AuthorDto findByIdWithBooks(Integer id) {

		Author author = authorsRepository.findById(id).get();
		AuthorDto dto = new AuthorDto();
		dto.setId(author.getId());
		dto.setName(author.getName());
		dto.setSurname(author.getSurname());

		try {		
			dto.setBooks(bookClient.findBooksByAuthor(id).getBody());
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
