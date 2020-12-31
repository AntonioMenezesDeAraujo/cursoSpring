package com.cursospringboot.bookstoragemanager.author.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cursospringboot.bookstoragemanager.author.builder.AuthorDTOBuilder;
import com.cursospringboot.bookstoragemanager.author.mapper.AuthorMapper;
import com.cursospringboot.bookstoragemanager.author.repository.AuthorRepository;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

	private final AuthorMapper authorMapper = AuthorMapper.INSTANCE;
	
	@Mock
	private AuthorRepository authorRepository;
	
	@InjectMocks
	private AuthorService authorService;
	
	private AuthorDTOBuilder authorDTOBuilder;
}
