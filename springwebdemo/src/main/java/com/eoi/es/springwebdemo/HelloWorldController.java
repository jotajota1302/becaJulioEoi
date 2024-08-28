package com.eoi.es.springwebdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
@Controller
public class HelloWorldController {

	@GetMapping
	public String sayHello() {
		
		return "welcome.html";
	}
	
	
}
