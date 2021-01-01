package com.cursospringboot.bookstoragemanager.author.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospringboot.bookstoragemanager.author.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

	Optional<Author> findByName(String name);
	
}
