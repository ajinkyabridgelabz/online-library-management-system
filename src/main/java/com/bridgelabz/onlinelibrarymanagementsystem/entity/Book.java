package com.bridgelabz.onlinelibrarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    long id;
    String title, author, genre, isbn;
    Date publishedDate;


    public long getId() {
        return id;
    }

}
