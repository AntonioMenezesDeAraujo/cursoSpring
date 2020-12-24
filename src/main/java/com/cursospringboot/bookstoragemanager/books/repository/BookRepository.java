package com.cursospringboot.bookstoragemanager.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospringboot.bookstoragemanager.books.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
