package Dao;

import Model.ReturnBook;
public interface ReturnBookDAO {
    ReturnBook returnBook(ReturnBook returnBook, int adminId);
    boolean checkTransactionId(int transactionId, ReturnBook returnBook);
    void plusStock (int bookId);
    void updateBook(int transactionId);
}
