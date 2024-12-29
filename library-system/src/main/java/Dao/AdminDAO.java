package Dao;
import Model.Admin;

public interface AdminDAO {
    void register(Admin admin);
    Admin logIn(String username, String password);
    void loginDashboard();
    void adminDashboard();
    void frontDashboard();
}
