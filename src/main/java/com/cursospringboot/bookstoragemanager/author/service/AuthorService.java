package com.cursospringboot.bookstoragemanager.author.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospringboot.bookstoragemanager.author.dto.AuthorDTO;
import com.cursospringboot.bookstoragemanager.author.entity.Author;
import com.cursospringboot.bookstoragemanager.author.exception.AuthorAlreadyExistsException;
import com.cursospringboot.bookstoragemanager.author.exception.AuthorNotFoundException;
import com.cursospringboot.bookstoragemanager.author.mapper.AuthorMapper;
import com.cursospringboot.bookstoragemanager.author.repository.AuthorRepository;

@Service
public class AuthorService {

	private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;

	private AuthorRepository authorRepository;

	public AuthorService() {
		super();
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

	public AuthorDTO findById(Long id) {
		Author foundAuthor = verifyAndGetAuthor(id);
		return authorMapper.toDTO(foundAuthor);
	}
	
	public List<AuthorDTO> findAll() {
		return authorRepository.findAll().stream().map(authorMapper::toDTO).collect(Collectors.toList());
	}
	
	public void delete(Long id) {
		verifyAndGetAuthor(id);
		this.authorRepository.deleteById(id);
	}
	
	private Author verifyAndGetAuthor(Long id) {
		Author foundAuthor = this.authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
		return foundAuthor;
	}
	
	
	private void verifyIsExists(String authorName) {
		authorRepository.findByName(authorName).ifPresent(author -> {
			throw new AuthorAlreadyExistsException(authorName);
		});
	}
}
