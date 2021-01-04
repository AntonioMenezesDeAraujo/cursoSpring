package com.cursospringboot.bookstoragemanager.publishers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospringboot.bookstoragemanager.publishers.service.PublisherService;

@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController {

	private PublisherService publisherService;
	
	public PublisherController() {
		
	}
	
	@Autowired
	public PublisherController(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
}
