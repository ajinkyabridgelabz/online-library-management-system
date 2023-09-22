package com.bridgelabz.onlinelibrarymanagementsystem.service;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;


import java.util.List;

import java.util.Optional;


public interface BookService {
    Book createBook(Book book);

    void deleteBook(Long bookId);

    List<Book> getAllBooks();
    List<Book> searchBook(String title);


}
