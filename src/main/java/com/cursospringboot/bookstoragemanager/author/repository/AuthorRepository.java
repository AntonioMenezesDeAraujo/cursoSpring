package com.cursospringboot.bookstoragemanager.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospringboot.bookstoragemanager.author.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
}
