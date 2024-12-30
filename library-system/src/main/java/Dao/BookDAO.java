package Dao;

import Model.Book;

import java.util.List;
import java.util.Scanner;

public interface BookDAO {
    List<Book> getBooks();
    Book getSpecificBook(int id);
    //Book getSpecificBook(String word);
    boolean addBook(Book book); //need ata dito ng separate class for author and publisher
    boolean updateBook(Book book);
    boolean deleteBook(int id);
    Book createBook(Scanner scanner);
    Book createUpdateBook(Scanner scanner);
}
