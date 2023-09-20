package com.bridgelabz.onlinelibrarymanagementsystem.controller;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;
import com.bridgelabz.onlinelibrarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        bookService.createBook(book);
        return ResponseEntity.ok(book);
    }


    @GetMapping("book/search")
    public ResponseEntity<Book> searchBook(@RequestParam String title){
        Book book = bookService.searchBook(title);
        return ResponseEntity.ok(book);
    }
}
