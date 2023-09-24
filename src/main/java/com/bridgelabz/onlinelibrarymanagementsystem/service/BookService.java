package com.bridgelabz.onlinelibrarymanagementsystem.service;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;


import java.sql.SQLException;
import java.util.List;

import java.util.Optional;


public interface BookService {
    Book createBook(Book book);

    void deleteBook(Long bookId) throws SQLException;

    List<Book> getAllBooks() throws SQLException;
    Book searchBook(String title) throws SQLException;


}
