package com.cursospringboot.bookstoragemanager.author.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.cursospringboot.bookstoragemanager.author.builder.AuthorDTOBuilder;
import com.cursospringboot.bookstoragemanager.author.dto.AuthorDTO;
import com.cursospringboot.bookstoragemanager.author.service.AuthorService;
import com.cursospringboot.bookstoragemanager.utils.JsonConversionUtils;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {

	@Mock
	private AuthorService authorService;

	@InjectMocks
	private AuthorController authorController;

	private MockMvc mockMvc;

	private AuthorDTOBuilder authorDTOBuilder;

	private final String AUTHOR_API_URL_PATH= "/api/v1/authors";
	
	@BeforeEach
	void setup() {
		this.authorDTOBuilder = AuthorDTOBuilder.builder().build();

		mockMvc = MockMvcBuilders.standaloneSetup(authorController)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
				.setViewResolvers((s, locale) -> new MappingJackson2JsonView()).build();
	}

	@Test
	void whenPOSTIsCalledThenStatusCreatedShouldBeReturned() throws Exception {
		AuthorDTO expectedCreatedAuthorDTO = authorDTOBuilder.builderAuthorDTO();

		Mockito.when(authorService.create(expectedCreatedAuthorDTO)).thenReturn(expectedCreatedAuthorDTO);

		mockMvc.perform(
				MockMvcRequestBuilders.post(AUTHOR_API_URL_PATH).contentType(JsonConversionUtils.asJsonString(expectedCreatedAuthorDTO)))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(expectedCreatedAuthorDTO.getId().intValue())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(expectedCreatedAuthorDTO.getName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.age", Is.is(expectedCreatedAuthorDTO.getAge())));

	}
	
	@Test
	void whenPOSTIsCalledWithoutRequiredFieldThenBadRequestStatusShouldBeInformed() throws Exception {
		AuthorDTO expectedCreatedAuthorDTO = authorDTOBuilder.builderAuthorDTO();
		
		expectedCreatedAuthorDTO.setName(null);

		mockMvc.perform(
				MockMvcRequestBuilders.post(AUTHOR_API_URL_PATH).contentType(JsonConversionUtils.asJsonString(expectedCreatedAuthorDTO)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

	@Test
	void whenGETWithValidIdIsCalledThenStatusOkShouldBeReturned() throws Exception {
		AuthorDTO expectedFoundAuthorDTO = authorDTOBuilder.builderAuthorDTO();

		Mockito.when(authorService.findById(expectedFoundAuthorDTO.getId())).thenReturn(expectedFoundAuthorDTO);

		mockMvc.perform(
				MockMvcRequestBuilders.get(AUTHOR_API_URL_PATH + "/" + expectedFoundAuthorDTO.getId()))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(expectedFoundAuthorDTO.getId().intValue())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(expectedFoundAuthorDTO.getName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.age", Is.is(expectedFoundAuthorDTO.getAge())));

	}
	
	@Test
	void whenGETListIsCalledThenStatusOkShouldBeReturned() throws Exception {
		AuthorDTO expectedFoundAuthorDTO = authorDTOBuilder.builderAuthorDTO();

		Mockito.when(authorService.findAll()).thenReturn(Collections.singletonList(expectedFoundAuthorDTO));

		mockMvc.perform(
				MockMvcRequestBuilders.get(AUTHOR_API_URL_PATH))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Is.is(expectedFoundAuthorDTO.getId().intValue())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Is.is(expectedFoundAuthorDTO.getName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].age", Is.is(expectedFoundAuthorDTO.getAge())));

	}
	
	@Test
	void whenDELETEWithValidIdIsCalledThenNoContentShouldBeReturned() throws Exception {
		AuthorDTO expectedAuthorDeletedDTO = authorDTOBuilder.builderAuthorDTO();
		
		Mockito.doNothing().when(authorService).delete(expectedAuthorDeletedDTO.getId());
		
		mockMvc.perform(delete(AUTHOR_API_URL_PATH + "/" + expectedAuthorDeletedDTO.getId())
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
				
		
	}
	
}
