package com.eoi.es.springwebdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/hello")
@Controller
public class HelloWorldController {

	@GetMapping
	@ResponseBody
	public String sayHello() {

		return "Hello World!";
	}
	
	

}
