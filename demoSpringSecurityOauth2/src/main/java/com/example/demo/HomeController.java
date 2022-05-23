package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String getHome() {
		return "Home";// "index.jsp";
	}

	@GetMapping("/restricted")
	public String restricted() {
		return "To enter you need to login";
	}

}
