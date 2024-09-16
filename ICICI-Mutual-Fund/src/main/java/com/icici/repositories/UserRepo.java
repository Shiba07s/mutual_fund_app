package com.icici.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icici.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
