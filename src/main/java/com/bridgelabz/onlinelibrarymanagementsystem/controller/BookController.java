package com.bridgelabz.onlinelibrarymanagementsystem.controller;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;
import com.bridgelabz.onlinelibrarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        bookService.createBook(book);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book){
        bookService.updateBook(bookId,book);
        return ResponseEntity.ok(book);
    }

}
