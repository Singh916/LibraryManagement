package com.example.LibraryManagement.model;

import java.time.LocalDate;

public class BookIssue {


    private int id;

    private String title;
    private int userId;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

}