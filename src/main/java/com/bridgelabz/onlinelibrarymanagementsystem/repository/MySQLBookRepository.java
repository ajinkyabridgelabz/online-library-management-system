package com.bridgelabz.onlinelibrarymanagementsystem.repository;

import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;
import com.bridgelabz.onlinelibrarymanagementsystem.util.DbConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MySQLBookRepository implements BookRepository {
    public MySQLBookRepository() throws SQLException {
    }


    DbConnection dbBonnection = new DbConnection();
    Connection connection = dbBonnection.getConnection();

    @Override
    public void save(Book book) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO employee (id,title,author,genre,isbn) VALUES (?, ?, ?, ?, ?)")) {
            statement.setLong(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setString(4, book.getGenre());
            statement.setString(5, book.getIsbn());


            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Long id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM employee WHERE id = ?")) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }


    }

    @Override
    public List<Book> findAll() throws SQLException {
        List<Book> books = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM book");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setGenre(resultSet.getString("genre"));
                book.setIsbn(resultSet.getString("isbn"));

                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Book findById(Long id) throws SQLException {
        Book book = null;
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee WHERE id = ?")) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    book = new Book();
                    book.setId(resultSet.getLong("id"));
                    book.setId(resultSet.getLong("id"));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setGenre(resultSet.getString("genre"));
                    book.setIsbn(resultSet.getString("isbn"));
                }
            }
        }
        return book;
    }

    @Override
    public Book findByTitle(String title) throws SQLException {
        Book book = null;
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee WHERE id = ?")) {
            statement.setString(3, title);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    book = new Book();
                    book.setId(resultSet.getLong("id"));
                    book.setId(resultSet.getLong("id"));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setGenre(resultSet.getString("genre"));
                    book.setIsbn(resultSet.getString("isbn"));
                }
            }
        }
        return book;
    }

}




