package com.roufid.tutorials.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class ArticleController {

	@GetMapping
	public String getSomething() {
		return "Roufid.com";
	}
}
