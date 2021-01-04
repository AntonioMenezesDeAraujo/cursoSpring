package com.cursospringboot.bookstoragemanager.publishers.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.cursospringboot.bookstoragemanager.publishers.builder.PublisherDTOBuilder;
import com.cursospringboot.bookstoragemanager.publishers.service.PublisherService;

@ExtendWith(MockitoExtension.class)
public class PublisherControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private PublisherService publisherService;
	
	@InjectMocks
	private PublisherController publisherController;
	
	private PublisherDTOBuilder publisherDTOBuilder;
	
	@BeforeEach
	void setup() {
		this.publisherDTOBuilder = PublisherDTOBuilder.builder().build();
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.publisherController)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
				.setViewResolvers((s, locale) -> new MappingJackson2JsonView())
				.build();
	}
}
