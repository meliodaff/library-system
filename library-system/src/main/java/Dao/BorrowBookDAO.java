package Dao;
import Model.BorrowBook;

import java.util.List;
import java.util.Scanner;

public interface BorrowBookDAO {
    List<BorrowBook> borrowedBooks();
    BorrowBook specificBorrowedBook(String studentId);
    boolean borrowBook(BorrowBook borrowBook);
    BorrowBook createBorrowBook(Scanner scanner);
    boolean checkAvailability(int bookId);


}
