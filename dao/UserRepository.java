package com.example.LibraryManagement.dao;

import com.example.LibraryManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
