package com.eoi.es;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer>{
	
	public List<Book> findByAuthor(Integer author);

}
