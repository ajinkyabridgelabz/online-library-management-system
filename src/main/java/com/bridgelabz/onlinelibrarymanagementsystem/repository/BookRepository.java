package com.bridgelabz.onlinelibrarymanagementsystem.repository;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {

    public Book save(Book book);
    public void delete(Long bookID);

    public List<Book> findAll();

    public List<Book> findByTitle(String title);


}
