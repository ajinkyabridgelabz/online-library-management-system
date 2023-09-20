package com.bridgelabz.onlinelibrarymanagementsystem.service;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;

public interface BookService {
    Book createBook(Book book);
    Book updateBook(int id, Book book);
}
