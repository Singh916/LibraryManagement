package com.example.LibraryManagement.dao;

import com.example.LibraryManagement.model.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookIssueRepository extends JpaRepository<BookIssue,Long> {
}
