package com.cursospringboot.bookstoragemanager.publishers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospringboot.bookstoragemanager.publishers.mapper.PublisherMapper;
import com.cursospringboot.bookstoragemanager.publishers.repository.PublisherRepository;

@Service
public class PublisherService {

	private final static PublisherMapper publisherMapper = PublisherMapper.INSTANCE;

	private PublisherRepository publisherRepository;

	public PublisherService() {

	}

	@Autowired
	public PublisherService(PublisherRepository publisherRepository) {
		this.publisherRepository = publisherRepository;
	}

}
