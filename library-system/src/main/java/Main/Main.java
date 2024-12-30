package Main;

import Dao.AdminDAO;
import Dao.AuthorDAO;
import Dao.BookDAO;
import Database.Database;
import Implementation.AdminDAOImplementation;
import Implementation.AuthorDAOImplementation;
import Implementation.BookDAOImplementation;
import Model.Book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        BookDAO bookDao = new BookDAOImplementation(database);
        AuthorDAO authorDao = new AuthorDAOImplementation();
        Scanner scanner = new Scanner(System.in);
        AdminDAO adminDAO = new AdminDAOImplementation();

        while(true){
        int chooseDashboard = adminDAO.frontDashboard();
        // Ensure user is logged in before proceeding
        if(chooseDashboard == 1){
            if (adminDAO.loginDashboard() == null) {
                throw new IllegalArgumentException("Invalid credentials");
            }
            System.out.println("Login successful!");
            while(true) {
                byte choiceAdminDashboard = adminDAO.adminDashboard();
                if (choiceAdminDashboard == 1) {
                    while (true) {
                        byte chooseBooksDashboard = adminDAO.booksDashboard();
                        if (chooseBooksDashboard == 1) {
                            adminDAO.displayBooks(bookDao.getBooks());
                        } else if (chooseBooksDashboard == 6) {
                            break;
                        }
                    }
                } else if (choiceAdminDashboard == 2) {
                    adminDAO.authorsDashboard();
                } else if (choiceAdminDashboard == 3) {
                    adminDAO.publishersDashboard();
                }
                else if (choiceAdminDashboard == 4){
                    break;
                }
            }
        }
        else if (chooseDashboard == 2){
            adminDAO.registerDashboard();
        }
        }

    }
}
