package com.cursospringboot.bookstoragemanager.author.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cursospringboot.bookstoragemanager.author.dto.AuthorDTO;
import com.cursospringboot.bookstoragemanager.author.entity.Author;

@Mapper
public interface AuthorMapper {

	AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
	
	Author toModel(AuthorDTO authorDTO);
	
	AuthorDTO toDTO(Author author);
}
