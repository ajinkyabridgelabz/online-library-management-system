package com.bridgelabz.onlinelibrarymanagementsystem.service;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;
import com.bridgelabz.onlinelibrarymanagementsystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
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
    public void deleteBook(Long bookId) throws SQLException {
//        Iterator<Book> iterator = bookRepo.iterator();
//        while (iterator.hasNext()) {
//            Book book = iterator.next();
//            if (book.getId() == bookId) {
//                iterator.remove();
//            }
//        }
        bookRepository.delete(bookId);
    }

    public List<Book> getAllBooks() throws SQLException {
        return bookRepository.findAll();

    }

    public Book searchBook(String title) throws SQLException {
//        for(Book book:bookRepo){
//            if(book.getTitle().equals(title))
//                return book;
//        }
       ;
        return  bookRepository.findByTitle(title);

    }
}