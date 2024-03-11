package com.javatechie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/greetings")
	public String greetings() {
		return "Hello Congratulations you have successfully completed Jenkins CI/CD demo !";
	}

}
