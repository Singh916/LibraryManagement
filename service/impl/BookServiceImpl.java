package com.example.LibraryManagement.service.impl;

import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.service.api.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    private Map<Long,Book> bookStorage = new HashMap<>();
    private Long bookSeqId=1L;

    @Override
    public Book addBook(Book book) {
         book.setId(bookSeqId++);
         bookStorage.put(book.getId(),book);
         return book;
    }

    @Override
    public Book getBookById(Long id) {
        Book book=bookStorage.get(id);
         if(book == null) {
             throw new RuntimeException("No book found with id: "+ id);
         }
         return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookStorage.values());
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = bookStorage.get(id);
        existingBook.setAuthor(book.getAuthor());
        existingBook.setTitle(book.getTitle());
        existingBook.setAvailable(book.isAvailable());
        existingBook.setName(book.getName());
        return book;
    }

    @Override
    public void deleteBook(Long id) {
        Book book =  bookStorage.get(id);
        bookStorage.remove(id);
    }
}
