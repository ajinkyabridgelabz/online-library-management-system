package com.bridgelabz.onlinelibrarymanagementsystem.service;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;
import com.bridgelabz.onlinelibrarymanagementsystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

//    List<Book> bookRepo= new ArrayList<>();
    @Autowired
    BookRepository bookRepository;
    @Override
    public Book createBook(Book book) {
//         bookRepo.add(book);
        bookRepository.save(book);
        return book;
    }

    @Override
    public void deleteBook(Long bookId) {
//        Iterator<Book> iterator = bookRepo.iterator();
//        while (iterator.hasNext()) {
//            Book book = iterator.next();
//            if (book.getId() == bookId) {
//                iterator.remove();
//            }
//        }
        bookRepository.delete(bookId);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    public List<Book> searchBook(String title){
//        for(Book book:bookRepo){
//            if(book.getTitle().equals(title))
//                return book;
//        }
        List<Book> book = bookRepository.findByTitle(title);
        return book;

    }
}

