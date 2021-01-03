package com.cursospringboot.bookstoragemanager.author.exception;

import javax.persistence.EntityNotFoundException;

public class AuthorNotFoundException extends EntityNotFoundException{

	private static final long serialVersionUID = 4171557288045388950L;

	public AuthorNotFoundException(Long id) {
		super(String.format("Author with id %s not exists!", id));
	}
}
