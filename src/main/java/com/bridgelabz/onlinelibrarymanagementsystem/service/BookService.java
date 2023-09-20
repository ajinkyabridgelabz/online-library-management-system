package com.bridgelabz.onlinelibrarymanagementsystem.service;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;

import java.util.Optional;

public interface BookService {
    Book createBook(Book book);

    Optional<Book> searchBook(String title);
}
