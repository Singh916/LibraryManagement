package com.example.LibraryManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

}

/*
   Model:
       Book, BookIssue, User

	   Dao:
		  BookRepository,BookIssueRepository,UserRepository

		  Book: id,name,title,author
		  BookIssue: id,title,userId,issueDate,dueDate,returnDate
		  User: id,name,email,role

	   Controller:
		   BookController,BookIssueController,UserController

		   Get,Post:  /books
		   Get,Put,Delete: /book/{id}
		   Get: /book/search?title=...&author ->filtered search

	   Service:
			BookService,BookIssueService,UserService


 */
