package com.cursospringboot.bookstoragemanager.publishers.builder;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public class PublisherDTOBuilder {

	@Builder.Default
	private final Long id = 1L;
	
	private final String name = "Peleias Editora";
	
	private final String code = "Peleias1234";
	
	private final LocalDate foundstionDate = LocalDate.of(2020, 6, 1);
}
