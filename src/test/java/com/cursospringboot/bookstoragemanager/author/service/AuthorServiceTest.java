package com.cursospringboot.bookstoragemanager.author.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.hamcrest.MatcherAssert;import org.hamcrest.core.Is;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cursospringboot.bookstoragemanager.author.builder.AuthorDTOBuilder;
import com.cursospringboot.bookstoragemanager.author.dto.AuthorDTO;
import com.cursospringboot.bookstoragemanager.author.entity.Author;
import com.cursospringboot.bookstoragemanager.author.exception.AuthorAlreadyExistsException;
import com.cursospringboot.bookstoragemanager.author.exception.AuthorNotFoundException;
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

	@BeforeEach
	void setup() {
		this.authorDTOBuilder = AuthorDTOBuilder.builder().build();
	}

	@Test
	void whenNewAuthorIsInformedThenItShouldBeCreated() {
		
		AuthorDTO expectedAuthorToCreateDTO = authorDTOBuilder.builderAuthorDTO();
		
		Author expectedCreatedAuthor = authorMapper.toModel(expectedAuthorToCreateDTO);

		Mockito.when(authorRepository.save(expectedCreatedAuthor)).thenReturn(expectedCreatedAuthor);
		
		Mockito.when(authorRepository.findByName(expectedAuthorToCreateDTO.getName())).thenReturn(Optional.empty());
		
		AuthorDTO createdAuthorDTO = authorService.create(expectedAuthorToCreateDTO);

		MatcherAssert.assertThat(createdAuthorDTO, is(equalTo(expectedAuthorToCreateDTO)));
	}
	
	@Test
	void whenExistingAuthorIsInformedThenAnExceptionShouldBeThrown() {
		
		AuthorDTO expectedAuthorToCreateDTO = authorDTOBuilder.builderAuthorDTO();
		
		Author expectedCreatedAuthor = authorMapper.toModel(expectedAuthorToCreateDTO);

		Mockito.when(authorRepository.findByName(expectedAuthorToCreateDTO.getName())).thenReturn(Optional.of(expectedCreatedAuthor));
		
		Assertions.assertThrows(AuthorAlreadyExistsException.class, () -> authorService.create(expectedAuthorToCreateDTO));
		
	}
	
	@Test
	void whenValidIdIsGivenThenAnAuthorShouldBeReturned() {
		AuthorDTO expectedFoundAuthorDTO = authorDTOBuilder.builderAuthorDTO();
		
		Author expectedFoundAuthor = authorMapper.toModel(expectedFoundAuthorDTO);
		
		Mockito.when(authorRepository.findById(expectedFoundAuthorDTO.getId())).thenReturn(Optional.of(expectedFoundAuthor));
		
		AuthorDTO foundAuthorDTO = authorService.findById(expectedFoundAuthorDTO.getId());
		
		MatcherAssert.assertThat(foundAuthorDTO, is(equalTo(expectedFoundAuthorDTO)));
	}
	
	@Test
	void whenInvalidIdIsGivenThenAnExceptionShouldBeThrown() {
		AuthorDTO expectedFoundAuthorDTO = authorDTOBuilder.builderAuthorDTO();
		
		Mockito.when(authorRepository.findById(expectedFoundAuthorDTO.getId())).thenReturn(Optional.empty());
		
		assertThrows(AuthorNotFoundException.class, () -> authorService.findById(expectedFoundAuthorDTO.getId())); 
		
	}
	
	@Test
	void whenListAuthorsIsCalledThenItShouldBeReturned() {
		AuthorDTO expectedFoundAuthorDTO = authorDTOBuilder.builderAuthorDTO();
		
		Author expectedFoundAuthor = authorMapper.toModel(expectedFoundAuthorDTO);
		
		Mockito.when(authorRepository.findAll()).thenReturn(Collections.singletonList(expectedFoundAuthor));
		
		List<AuthorDTO> foundAuthorsDTO = authorService.findAll();
		
		MatcherAssert.assertThat(foundAuthorsDTO.size(), is(1));
		
		MatcherAssert.assertThat(foundAuthorsDTO.get(0), is(equalTo(expectedFoundAuthorDTO)));
	}
	
	@Test
	void whenListAuthorsIsCalledThenAnEmptyListShouldBeReturned() {
		
		Mockito.when(authorRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
		
		List<AuthorDTO> foundAuthorsDTO = authorService.findAll();
		
		MatcherAssert.assertThat(foundAuthorsDTO.size(), is(0));
	}
	 
}
