package com.bridgelabz.onlinelibrarymanagementsystem.service;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    List<Book> bookRepo= new ArrayList<>();
    @Override
    public String createBook(Book book) {
         bookRepo.add(book);
        return "Succefull added";
    }
}
