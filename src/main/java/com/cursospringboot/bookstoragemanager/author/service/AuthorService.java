package com.cursospringboot.bookstoragemanager.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospringboot.bookstoragemanager.author.dto.AuthorDTO;
import com.cursospringboot.bookstoragemanager.author.entity.Author;
import com.cursospringboot.bookstoragemanager.author.exception.AuthorAlreadyExistsException;
import com.cursospringboot.bookstoragemanager.author.mapper.AuthorMapper;
import com.cursospringboot.bookstoragemanager.author.repository.AuthorRepository;

@Service
public class AuthorService {

	private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;

	private AuthorRepository authorRepository;

	public AuthorService() {
		
	}
	
	@Autowired
	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public AuthorDTO create(AuthorDTO authorDTO) {

		verifyIsExists(authorDTO.getName());

		Author authorToCreate = authorMapper.toModel(authorDTO);
		Author createdAuthor = authorRepository.save(authorToCreate);
		return authorMapper.toDTO(createdAuthor);
	}

	private void verifyIsExists(String authorName) {
		authorRepository.findByName(authorName).ifPresent(author -> {
			throw new AuthorAlreadyExistsException(authorName);
		});
	}
}
