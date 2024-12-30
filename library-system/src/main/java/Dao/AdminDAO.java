package Dao;
import Model.Admin;
import Model.Book;
import java.util.List;

public interface AdminDAO {
    void register(Admin admin);
    Admin logIn(String username, String password);
    Admin loginDashboard();
    byte adminDashboard();
    byte frontDashboard();
    byte booksDashboard();
    void authorsDashboard();
    void publishersDashboard();
    void displayBooks(List<Book> books);
    void registerDashboard();
}
