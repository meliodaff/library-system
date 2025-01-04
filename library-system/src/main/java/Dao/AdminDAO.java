package Dao;
import Model.Admin;
import java.util.Scanner;

public interface AdminDAO {
    void register(Admin admin);
    Admin logIn(String username, String password);
    Admin loginDashboard();
    byte adminDashboard();
    byte frontDashboard();
    void registerDashboard();
    int getAdminId();
    Admin validateSuperAdmin(String username, String password);
    Admin displaySuperAdmin(Scanner scanner);

}
