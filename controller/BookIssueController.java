package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.model.BookIssue;
import com.example.LibraryManagement.service.api.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class BookIssueController {

    @Autowired
    private BookIssueService bookIssueService;

    @PostMapping("/issue")
    public BookIssue issueBook(@RequestParam Long bookId,@RequestParam Long userId) {
         return bookIssueService.issueBook(bookId,userId);
    }

    @GetMapping
    public List<BookIssue> getAllIssue() {
        return bookIssueService.getAllIssuedBooks();
    }

    @PutMapping("/return/{issueId}")
    public BookIssue returnBook(@PathVariable Long issueId) {
       return bookIssueService.returnBook(issueId);
    }

    @GetMapping("/{issueId}")
    public BookIssue getIssueById(@PathVariable Long issueId) {
        return bookIssueService.getIssueById(issueId);
    }


}
