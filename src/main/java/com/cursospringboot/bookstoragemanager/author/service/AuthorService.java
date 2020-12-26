package com.cursospringboot.bookstoragemanager.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospringboot.bookstoragemanager.author.mapper.AuthorMapper;
import com.cursospringboot.bookstoragemanager.author.repository.AuthorRepository;

@Service
public class AuthorService {

	private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;

	private AuthorRepository authorRepository;

	@Autowired
	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
}
