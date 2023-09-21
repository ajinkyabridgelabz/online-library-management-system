package com.bridgelabz.onlinelibrarymanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private long id;
    private String title, author, genre, isbn;
    private Date publishedDate;
}
