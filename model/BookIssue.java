package com.example.LibraryManagement.model;

import java.time.LocalDate;

public class BookIssue {

    private Long id;
    private Long BookId;
    private Long userId;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public BookIssue(Long id, Long bookId, Long userId, LocalDate issueDate, LocalDate returnDate) {
        this.id = id;
        BookId = bookId;
        this.userId = userId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return BookId;
    }

    public void setBookId(Long bookId) {
        BookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

}