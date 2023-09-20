package com.bridgelabz.onlinelibrarymanagementsystem.service;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    List<Book> bookRepo= new ArrayList<>();
    @Override
    public Book createBook(Book book) {
         bookRepo.add(book);
        return book;
    }
    @Override
    public List<Book> getAllBooks() {
        return bookRepo;
    }
}
