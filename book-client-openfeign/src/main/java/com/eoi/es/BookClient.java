package com.eoi.es;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BOOKS")
public interface BookClient {

	@GetMapping("books/{id}")
	public BookDto getBookById(@PathVariable("id") Integer id);

}