package com.cursospringboot.bookstoragemanager.publishers.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cursospringboot.bookstoragemanager.publishers.dto.PublisherDTO;
import com.cursospringboot.bookstoragemanager.publishers.entity.Publisher;

@Mapper
public interface PublisherMapper {

	PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);
	
	Publisher toModel(PublisherDTO publisherDTO);
	
	PublisherDTO toDTO(Publisher publisher);
}
