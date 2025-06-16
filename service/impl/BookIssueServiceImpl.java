package com.example.LibraryManagement.service.impl;

import com.example.LibraryManagement.dao.BookIssueRepository;
import com.example.LibraryManagement.dao.BookRepository;
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

    @Autowired
    private BookIssueRepository bookIssueRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookIssue issueBook(Long bookId, Long userId) {
        Book book= bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: "+bookId));
        if(!book.isAvailable()) {
            throw new RuntimeException("Book is not available for issuing with id: " + bookId);
        }
        book.setAvailable(false);
        bookRepository.save(book);
        BookIssue bookIssue = new BookIssue();
        bookIssue.setBookId(bookId);
        bookIssue.setUserId(userId);
        bookIssue.setIssueDate(LocalDate.now());
        return bookIssueRepository.save(bookIssue);
    }

    @Override
    public BookIssue returnBook(Long issueId) {
         BookIssue bookIssue = bookIssueRepository.findById(issueId)
                 .orElseThrow(()->new RuntimeException("Book not found with issueId: "+issueId));
         if(bookIssue.getReturnDate()!=null) {
             throw new RuntimeException("Book already returned");
         }
         Book book = bookRepository.findById(bookIssue.getBookId())
                 .orElseThrow(()->new RuntimeException("Book not found with bookId: "+bookIssue.getBookId()));
         book.setAvailable(true);
         bookRepository.save(book);
         bookIssue.setReturnDate(LocalDate.now());
         return bookIssueRepository.save(bookIssue);
    }

    @Override
    public List<BookIssue> getAllIssuedBooks() {
        return bookIssueRepository.findAll();
    }

    @Override
    public BookIssue getIssueById(Long id) {
        return bookIssueRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Book not found with issueId: "+id));
    }
}
