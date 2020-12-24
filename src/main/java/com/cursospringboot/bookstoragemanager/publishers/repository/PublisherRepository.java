package com.cursospringboot.bookstoragemanager.publishers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospringboot.bookstoragemanager.publishers.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long>{

}
