package Dao;
import Model.Admin;
import java.util.Scanner;

public interface AdminDAO {

    void register(Admin admin);
    boolean isUsernameExists(String username);
    Admin logIn(String username, String password);
    int getAdminId();
    Admin validateSuperAdmin(String username, String password);

}
