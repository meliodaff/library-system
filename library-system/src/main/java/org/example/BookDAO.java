package org.example;

import java.util.List;

public interface BookDAO {
    List<Book> getBooks();
    Book getSpecificBook(int id);
    Book getSpecificBook(String word);
    //boolean addBook(Book book);
    //boolean updateBook(Book book);
    //boolean deleteBook(int id);
}
