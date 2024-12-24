package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookDAO bookDao = new BookDAOImplementation();

        System.out.println(bookDao.getSpecificBook("dsa"));

/*
        List<Book> books = bookDao.getBooks();
        for(Book book : books){
            System.out.println("Book ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Year: " + book.getYear());
            System.out.println("Stock: " + book.getStock());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("--------------");
        }
 */
    }
}
