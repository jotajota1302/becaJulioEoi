package com.eoi.es;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AUTHORS")
public interface AuthorClient {

	@GetMapping("authors/{id}")
	public AuthorDto getAuthorById(@PathVariable("id") Integer id);

}