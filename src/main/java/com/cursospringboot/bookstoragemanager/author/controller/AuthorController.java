package com.cursospringboot.bookstoragemanager.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospringboot.bookstoragemanager.author.service.AuthorService;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController implements AuthorControllerDocs{

	private AuthorService authorService;
	
	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
}
