package com.bridgelabz.onlinelibrarymanagementsystem.service;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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
    public void deleteBook(Long bookId) {
        Iterator<Book> iterator = bookRepo.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId()==bookId) {
                iterator.remove();
            }else {
                System.out.println("not found");
            }
        }
    }
}

