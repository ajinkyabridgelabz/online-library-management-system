package com.bridgelabz.onlinelibrarymanagementsystem.service;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;


import java.util.List;

import java.util.Optional;


public interface BookService {
    Book createBook(Book book);
    List<Book> getAllBooks();
    Book searchBook(String title);

}
