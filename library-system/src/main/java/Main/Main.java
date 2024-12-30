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
        if(chooseDashboard == 1){
            if (adminDAO.loginDashboard() == null) {
                throw new IllegalArgumentException("Username does not exist");
            }
            System.out.println("Login successful!");
            while(true) {
                byte choiceAdminDashboard = adminDAO.adminDashboard();
                if (choiceAdminDashboard == 1) {
                    while (true) {
                        byte chooseBooksDashboard = adminDAO.booksDashboard();
                        if (chooseBooksDashboard == 1) {
                            adminDAO.displayBooks(bookDao.getBooks());
                        }
                        else if (chooseBooksDashboard == 2){
                            scanner.next(); // consume the buffer line
                            System.out.print("Book ID: ");
                            System.out.println(bookDao.getSpecificBook(scanner.nextByte())); // change this if ever the records of book reach hundreds
                            System.out.println("-------------------------");
                        }
                        else if (chooseBooksDashboard == 3) {
                            Book book = bookDao.createBook(scanner);
                            if(bookDao.addBook(book)) System.out.println("Added successfully");
                            else System.out.println("An error has occurred");
                        }
                        else if (chooseBooksDashboard == 4){

                        }

                        else if (chooseBooksDashboard == 6) {
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
