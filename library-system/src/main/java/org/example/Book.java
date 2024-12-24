package org.example;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Book {

    private int id;
    private String title;
    private String genre;
    private String year;
    private int stock;
    private String author;
    private String publisher;

    // constructor without id for inserting and updating data
    public Book(String title, String genre, String year, int stock, String author, String publisher){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.stock = stock;
        this.author = author;
        this.publisher = publisher;
    }
}