package com.bridgelabz.onlinelibrarymanagementsystem.service;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    List<Book> bookRepo= new ArrayList<>();
    @Override
    public Book createBook(Book book) {
         bookRepo.add(book);
        return book;
    }


    public Book searchBook(String title){
        for(Book book:bookRepo){
            if(book.getTitle().equals(title))
                return book;
        }
        return null;
    }
}
