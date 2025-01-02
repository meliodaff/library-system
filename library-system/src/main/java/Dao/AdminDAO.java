package Dao;
import Model.Admin;
import Model.Author;
import Model.Book;
import Model.Publisher;

import java.util.List;

public interface AdminDAO {
    void register(Admin admin);
    Admin logIn(String username, String password);
    Admin loginDashboard();
    byte adminDashboard();
    byte frontDashboard();
    void registerDashboard();
    int getAdminId();
}
