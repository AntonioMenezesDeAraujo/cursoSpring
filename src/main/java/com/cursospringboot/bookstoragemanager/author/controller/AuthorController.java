package com.cursospringboot.bookstoragemanager.author.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cursospringboot.bookstoragemanager.author.dto.AuthorDTO;
import com.cursospringboot.bookstoragemanager.author.service.AuthorService;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController implements AuthorControllerDocs {

	private AuthorService authorService;
	
	public AuthorController() {
		super();
	}

	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AuthorDTO create(@RequestBody @Valid AuthorDTO authorDTO) {
		return authorService.create(authorDTO);
	}
	
	@GetMapping("/{id}")
	public AuthorDTO findById(@PathVariable Long id) {
		return authorService.findById(id);
	}
	
	@GetMapping
	public List<AuthorDTO> findAll() {
		return authorService.findAll();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		authorService.delete(id);
	}
	
}
