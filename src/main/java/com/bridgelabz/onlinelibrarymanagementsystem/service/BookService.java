package com.bridgelabz.onlinelibrarymanagementsystem.service;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);

    List<Book> getAllBooks();
}
