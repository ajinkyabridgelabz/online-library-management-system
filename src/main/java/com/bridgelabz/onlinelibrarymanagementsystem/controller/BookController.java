package com.bridgelabz.onlinelibrarymanagementsystem.controller;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;
import com.bridgelabz.onlinelibrarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        bookService.createBook(book);
        return ResponseEntity.ok(book);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

}
