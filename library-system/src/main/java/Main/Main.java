package Main;

import Dao.AdminDAO;
import Dao.AuthorDAO;
import Dao.BookDAO;
import Database.Database;
import Implementation.AdminDAOImplementation;
import Implementation.AuthorDAOImplementation;
import Implementation.BookDAOImplementation;
import Model.Author;
import Model.Book;

import java.util.ArrayList;
import java.util.List;
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
                return;
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
                            System.out.print("Book ID: ");
                            System.out.println(bookDao.getSpecificBook(scanner.nextByte()));// change this if ever the records of book reach hundreds
                            // the adminDAOImplementation handles the rendering for input while in here, this handles itself's rendering
                            System.out.println("-------------------------");
                        }
                        else if (chooseBooksDashboard == 3) {
                            Book book = bookDao.createBook(scanner);
                            if(bookDao.addBook(book)) System.out.println("Added successfully");
                            else System.out.println("An error has occurred");
                        }
                        else if (chooseBooksDashboard == 4){
                            Book book = bookDao.createUpdateBook(scanner);
                            if(bookDao.updateBook(book)) System.out.println("Book ID " + book.getId() + " Updated Successfully");
                            else System.out.println("An error has occurred");
                        }
                        else if (chooseBooksDashboard == 5){
                            System.out.print("Delete Book ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            if(bookDao.deleteBook(id)) System.out.println("Book ID " + id + " Deleted");
                            else System.out.println("An error has occurred");
                        }
                        else if (chooseBooksDashboard == 6) {
                            break;
                        }
                    }
                } else if (choiceAdminDashboard == 2) {
                    while(true){
                    byte chooseAuthorsDashboard = adminDAO.authorsDashboard();
                    if(chooseAuthorsDashboard == 1){
                       List<Author> author = authorDao.getAuthors();
                       adminDAO.displayAuthors(author);
                    }
                    else if (chooseAuthorsDashboard == 2){
                        System.out.print("Author ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        Author author = authorDao.getSpecificAuthor(id);
                        adminDAO.displaySpecificAuthor(author);
                    }
                    else if (chooseAuthorsDashboard == 3){
                        System.out.print("Book ID: ");
                        int id = scanner.nextInt();
                        List<Author> author = authorDao.getAuthorBooks(id);
                        adminDAO.displayAuthorBooks(author);
                    }
                    else if (chooseAuthorsDashboard == 4) {
                        Author author = authorDao.createAuthor(scanner);
                        if(authorDao.addAuthor(author)) System.out.println("Author " + author.getName() + " Added Successfully");
                        else System.out.println("An error has occurred");

                    }
                    else if (chooseAuthorsDashboard == 5){
                        Author author = authorDao.createUpdateAuthor(scanner);
                        if(authorDao.updateAuthor(author)) System.out.println("Author ID " + author.getId() + " Updated Successfully");
                        else System.out.println("An error has occured");
                    }
                    else if (chooseAuthorsDashboard == 6){
                        System.out.print("Admin ID to be deleted: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        if(authorDao.deleteAuthor(id)) System.out.println("Author ID " + id + " Successfully deleted");
                        else System.out.println("An error has occurred");
                    }
                    else if (chooseAuthorsDashboard == 7){
                           break;
                       }

                    }

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
