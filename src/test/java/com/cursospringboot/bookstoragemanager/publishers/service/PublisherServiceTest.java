package com.cursospringboot.bookstoragemanager.publishers.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cursospringboot.bookstoragemanager.publishers.builder.PublisherDTOBuilder;
import com.cursospringboot.bookstoragemanager.publishers.mapper.PublisherMapper;
import com.cursospringboot.bookstoragemanager.publishers.repository.PublisherRepository;

@ExtendWith(MockitoExtension.class)
public class PublisherServiceTest {

	private final PublisherMapper publisherMapper = PublisherMapper.INSTANCE;
	
	@Mock
	private PublisherRepository publisherRepository;
	
	@InjectMocks
	private PublisherService publisherService;
	
	private PublisherDTOBuilder publisherDTOBuilder;
	
	@BeforeEach
	void setup() {
		this.publisherDTOBuilder = PublisherDTOBuilder.builder().build();
	}
}
