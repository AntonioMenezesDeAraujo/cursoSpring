package com.cursospringboot.bookstoragemanager.books.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.cursospringboot.bookstoragemanager.author.entity.Author;
import com.cursospringboot.bookstoragemanager.entity.Auditable;
import com.cursospringboot.bookstoragemanager.publishers.entity.Publisher;
import com.cursospringboot.bookstoragemanager.users.entity.User;

import lombok.Data;

@Data
@Entity
public class Book extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false)
	private String isbn;

	@Column(columnDefinition = "integer default 0")
	private int pages;

	@Column(columnDefinition = "integer default 0")
	private int chapters;

	@ManyToOne(cascade = { CascadeType.MERGE })
	private Author author;
	
	@ManyToOne(cascade = { CascadeType.MERGE })
	private Publisher publisher;
	
	@ManyToOne(cascade = { CascadeType.MERGE })
	private User user;
}
