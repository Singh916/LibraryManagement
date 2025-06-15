package com.example.LibraryManagement.service.api;

import com.example.LibraryManagement.model.BookIssue;

import java.util.List;

public interface BookIssueService {

    BookIssue issueBook(Long BookId,Long userId);

    BookIssue returnBook(Long issueId);

    List<BookIssue> getAllIssuedBooks();

    BookIssue getIssueById(Long id);
}
