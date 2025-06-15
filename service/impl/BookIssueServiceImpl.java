package com.example.LibraryManagement.service.impl;

import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.model.BookIssue;
import com.example.LibraryManagement.service.api.BookIssueService;
import com.example.LibraryManagement.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookIssueServiceImpl implements BookIssueService {

    private final Map<Long, BookIssue> bookIssueStorage = new HashMap<>();
    private Long bookIssueSeq=1L;

    @Autowired
    private BookService bookService;

    @Override
    public BookIssue issueBook(Long bookId, Long userId) {
        Book book= bookService.getBookById(bookId);
        if(!book.isAvailable()) {
            throw new RuntimeException("Book is not available for issuing with id: " + bookId);
        }
        book.setAvailable(false);
        BookIssue bookIssue = new BookIssue(bookIssueSeq++,bookId,userId, LocalDate.now(),null);
        bookIssueStorage.put(bookIssue.getId(),bookIssue);
        return bookIssue;
    }

    @Override
    public BookIssue returnBook(Long issueId) {
         BookIssue bookIssue = bookIssueStorage.get(issueId);
         if(bookIssue.getReturnDate()!=null) {
             throw new RuntimeException("Book already returned");
         }
         Book book = bookService.getBookById(bookIssue.getBookId());
         book.setAvailable(true);
         bookIssue.setReturnDate(LocalDate.now());
         return bookIssue;
    }

    @Override
    public List<BookIssue> getAllIssuedBooks() {
        return new ArrayList<>(bookIssueStorage.values());
    }

    @Override
    public BookIssue getIssueById(Long id) {
        BookIssue bookIssue = bookIssueStorage.get(id);
        if (bookIssue == null) {
            throw new RuntimeException("Issue not found with id: " + id);
        }
        return bookIssue;
    }
}
