package com.bridgelabz.onlinelibrarymanagementsystem.repository;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
    void save(Book book);

    void delete(Long id) throws SQLException;

    public List<Book> findAll() throws SQLException;

    Book findById(Long id) throws SQLException;

    Book findByTitle(String title) throws SQLException;
}
