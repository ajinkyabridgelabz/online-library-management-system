package com.bridgelabz.onlinelibrarymanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    int id;
    String title, author, genre, isbn;
    Date publishedDate;


    public boolean getId() {
        return true;
    }

}
