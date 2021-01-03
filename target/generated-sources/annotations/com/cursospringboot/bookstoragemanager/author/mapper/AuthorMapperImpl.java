package com.cursospringboot.bookstoragemanager.author.mapper;

import com.cursospringboot.bookstoragemanager.author.dto.AuthorDTO;
import com.cursospringboot.bookstoragemanager.author.entity.Author;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-03T14:57:58-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author toModel(AuthorDTO authorDTO) {
        if ( authorDTO == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( authorDTO.getId() );
        author.setName( authorDTO.getName() );
        if ( authorDTO.getAge() != null ) {
            author.setAge( authorDTO.getAge() );
        }

        return author;
    }

    @Override
    public AuthorDTO toDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId( author.getId() );
        authorDTO.setName( author.getName() );
        authorDTO.setAge( author.getAge() );

        return authorDTO;
    }
}
