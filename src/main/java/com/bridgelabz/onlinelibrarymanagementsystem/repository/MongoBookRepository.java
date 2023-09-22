package com.bridgelabz.onlinelibrarymanagementsystem.repository;

import com.bridgelabz.onlinelibrarymanagementsystem.config.MongoConfig;
import com.bridgelabz.onlinelibrarymanagementsystem.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;

@Repository
public class MongoBookRepository implements BookRepository{

    @Value("${companyname.com.database_url}")
    private String databaseUrl;
    @Value("${companyname.com.dbName}")
    private String dbName;
    @Value("${companyname.com.collectionName}")
    private String collectionName;

    @Autowired
    MongoConfig mongoConfig;
    MongoClient mongoClient;

    public MongoDatabase createConnection(){

        mongoClient = MongoClients.create(databaseUrl);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName);
        return mongoDatabase;
    }



    // Create the connnection -- will give you an instance of the connection

    // When to close the connection


    // import the mondo db drivers

    //  import jdbc drivers

    // Create prepared statement  -- insertion of the data

    // create statement ---create the table in the database

    @Override
    public Book save(Book book) {
        System.out.println(mongoClient);
        MongoDatabase mongoDatabase = createConnection();
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        ObjectMapper objectMapper = mongoConfig.objectMapper();
        //using mongoconfig to ignore the 0bject id created by mongoDb
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String formattedDate = dateFormat.format(book.getPublishedDate());

        Document bsonDocument = new Document("id", book.getId())
                .append("title", book.getTitle())
                .append("author", book.getAuthor())
                .append("genre", book.getGenre())
                .append("isbn", book.getIsbn())
                .append("publishedDate", formattedDate);

        collection.insertOne(bsonDocument);

        mongoClient.close();
        System.out.println(mongoClient.listDatabases());
        return book;
    }

    @Override
    public void delete(Long bookId) {
        MongoDatabase mongoDatabase = createConnection();
        MongoCollection<Document> collection = mongoDatabase.getCollection("newlibrary");

        DeleteResult result = collection.deleteOne(Filters.eq("id", bookId));
        if (result.getDeletedCount() == 0) {
            throw new RuntimeException("No document found with the specified ID: " + bookId);
        }
    }
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        MongoDatabase mongoDatabase = createConnection();
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        for (Document document : collection.find()) {
            try {
                long id = document.getLong("id");
                String title = document.getString("title");
                String author = document.getString("author");
                String genre = document.getString("genre");
                String isbn = document.getString("isbn");
                java.util.Date publishedDate = dateFormat.parse(document.getString("publishedDate"));

                Book book = new Book();
                book.setId(id);
                book.setTitle(title);
                book.setAuthor(author);
                book.setGenre(genre);
                book.setIsbn(isbn);
                book.setPublishedDate(publishedDate);

                books.add(book);
            } catch (ParseException e) {
                // Handle parsing exception if needed
                e.printStackTrace();
            }
        }
        mongoClient.close();
        return books;
    }

    /*@Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        MongoDatabase mongoDatabase = createConnection();
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTimeFormatter desiredFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        for (Document document : collection.find()) {
            try {
                long id = document.getLong("id");
                String title = document.getString("title");
                String author = document.getString("author");
                String genre = document.getString("genre");
                String isbn = document.getString("isbn");
                String publishedDateStr = document.getString("publishedDate");

                LocalDateTime publishedDateTime = LocalDateTime.parse(publishedDateStr, dateFormat);

                // Convert LocalDateTime to Date
                Date publishedDate = java.util.Date.from(publishedDateTime.atZone(ZoneId.systemDefault()).toInstant());

                String formattedDate = publishedDateTime.format(desiredFormat);

                Book book = new Book();
                book.setId(id);
                book.setTitle(title);
                book.setAuthor(author);
                book.setGenre(genre);
                book.setIsbn(isbn);
                book.setPublishedDate(publishedDate);

                books.add(book);
            } catch (DateTimeParseException e) {
                // Handle parsing exception if needed
                e.printStackTrace();
            }
        }
        mongoClient.close();
        return books;
    }*/


    public List<Book> findByTitle(String title) {
        List<Book> books = new ArrayList<>();
        MongoDatabase mongoDatabase = createConnection();
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        BasicDBObject titleQuery = new BasicDBObject("title", Pattern.compile(Pattern.quote(title), Pattern.CASE_INSENSITIVE));

        for (Document document : collection.find(titleQuery)) {
            try {
                long id = document.getLong("id");
                String bookTitle = document.getString("title");
                String author = document.getString("author");
                String genre = document.getString("genre");
                String isbn = document.getString("isbn");
                java.util.Date publishedDate = dateFormat.parse(document.getString("publishedDate"));

                Book book = new Book();
                book.setId(id);
                book.setTitle(bookTitle);
                book.setAuthor(author);
                book.setGenre(genre);
                book.setIsbn(isbn);
                book.setPublishedDate(publishedDate);

                books.add(book);
            } catch (ParseException e) {
                // Handle parsing exception if needed
                e.printStackTrace();
            }
        }
        mongoClient.close();
        return books;
    }

}

