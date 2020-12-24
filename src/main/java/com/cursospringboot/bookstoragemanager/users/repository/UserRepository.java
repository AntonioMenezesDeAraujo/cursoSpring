package com.cursospringboot.bookstoragemanager.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospringboot.bookstoragemanager.users.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
