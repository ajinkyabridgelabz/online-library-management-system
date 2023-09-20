package com.bridgelabz.onlinelibrarymanagementsystem.service;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    List<Book> bookRepo = new ArrayList<>();

    @Override
    public Book createBook(Book book) {
        bookRepo.add(book);
        return book;
    }

    @Override
    public Book updateBook(int id, Book book) {
        Iterator<Book> iterator = bookRepo.iterator();
        while (iterator.hasNext()) {
            Book next = iterator.next();
            if (next.getId() == id) {
                createBook(book);
                return book;
            }
        }
        return null;
    }
}
