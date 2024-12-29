package Main;

import Dao.AdminDAO;
import Dao.AuthorDAO;
import Dao.BookDAO;
import Database.Database;
import Implementation.AuthorDAOImplementation;
import Implementation.BookDAOImplementation;
import Model.Author;
import Model.Book;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        BookDAO bookDao = new BookDAOImplementation(database);
        AuthorDAO authorDao = new AuthorDAOImplementation();
        Scanner scanner = new Scanner(System.in);
        AdminDAO adminDAO = new AdminDAOImplementation();

        adminDAO.frontDashboard();





    }
}
