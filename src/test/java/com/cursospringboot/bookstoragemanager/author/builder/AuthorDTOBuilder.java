package com.cursospringboot.bookstoragemanager.author.builder;

import com.cursospringboot.bookstoragemanager.author.dto.AuthorDTO;

import lombok.Builder;

@Builder
public class AuthorDTOBuilder {

	@Builder.Default
	private final Long id = 1L;

	@Builder.Default
	private final String name = "Antonio Menezes";

	@Builder.Default
	private final int age = 32;

	public AuthorDTO builderAuthorDTO() {
		return new AuthorDTO(id, name, age);
	}
}
