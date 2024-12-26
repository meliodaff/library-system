package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookDAO bookDao = new BookDAOImplementation();
        AuthorDAO authorDao = new AuthorDAOImplementation();

        List<Author> authors = authorDao.getAuthors();
        //Book book1 = new Book(5, "title3", "genre3", "2024-11-11", 30, 2 ,2 );
        //boolean result = bookDao.updateBook(book1);
        //System.out.println(result);
        //bookDao.addBook(book1);
        //boolean result = bookDao.deleteBook(5);
        //System.out.println(result);

/*
        for(Author author : authors){
            System.out.println("Author ID: " + author.getId());
            System.out.println("Name: " + author.getName());
            System.out.println("Email: " + author.getEmail());
            System.out.println("--------------");
         */

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



    }
}
