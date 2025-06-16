package com.example.LibraryManagement.dao;

import com.example.LibraryManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
