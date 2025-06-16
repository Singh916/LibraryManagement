package com.example.LibraryManagement.service.impl;

import com.example.LibraryManagement.dao.BookRepository;
import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
         return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
       return bookRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Book not found with id: "+id));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = getBookById(id);
        existingBook.setAuthor(book.getAuthor());
        existingBook.setTitle(book.getTitle());
        existingBook.setAvailable(book.isAvailable());
        existingBook.setName(book.getName());
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
