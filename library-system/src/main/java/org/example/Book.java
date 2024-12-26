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
    private String author; // taga kuha lang to guys ng pangalan sa db para lang may placeholder, hindi kasi pwedeng id gamitin ditu guys kasi hindi mababasa ng end user
    private String publisher;

    private int authorId; // eto para pang update ng author sa db
    private int publisherId; // '' publisher sa db

    // constructor for inserting book information
    public Book(String title, String genre, String year, int stock, int authorId, int publisherId){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.stock = stock;
        this.authorId = authorId;
        this.publisherId = publisherId;
    }

    // constructor for updating book information
    public Book(int id, String title, String genre, String year, int stock, int authorId, int publisherId){
        // ano ba mas ideal guys? sa dulo yung id kasi diba sa query ng UPDATE na sa dulo yung WHERE clause para sa id
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.stock = stock;
        this.authorId = authorId;
        this.publisherId = publisherId;
    }

}