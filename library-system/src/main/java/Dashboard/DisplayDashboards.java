package Dashboard;

import Dao.*;
import Database.Database;
import Implementation.*;
import Model.*;

import java.util.List;
import java.util.Scanner;

public class DisplayDashboards {
    BooksDashboard booksDashboard = new BooksDashboard();

    public void displayOne(){
        BooksDashboard booksDashboard = new BooksDashboard();
        Database database = new Database();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            BookDAO bookDao = new BookDAOImplementation(database);
            byte chooseBooksDashboard = booksDashboard.booksDashboard();
            if (chooseBooksDashboard == 1) {
                booksDashboard.displayBooks(bookDao.getBooks());
            }
            else if (chooseBooksDashboard == 2){
                System.out.print("Book ID: ");
                System.out.println(bookDao.getSpecificBook(scanner.nextByte()));// change this if ever the records of book reach hundreds
                // the adminDAOImplementation handles the rendering for input while in here, this handles itself's rendering
                System.out.println("-------------------------");
            }
            else if (chooseBooksDashboard == 3) {
                scanner.nextLine();
                Book book = booksDashboard.createBook(scanner);
                if(bookDao.addBook(book)) System.out.println("Added successfully");
                else System.out.println("An error has occurred");
            }
            else if (chooseBooksDashboard == 4){
                Book book = booksDashboard.createUpdateBook(scanner, booksDashboard);
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
    }

    public void displayTwo(){
        Database database = new Database();
        AuthorsDashboard authorsDashboard = new AuthorsDashboard();
        AuthorDAO authorDao = new AuthorDAOImplementation(database);
        Scanner scanner = new Scanner(System.in);
        while(true){
            byte chooseAuthorsDashboard = authorsDashboard.authorsDashboard();
            if(chooseAuthorsDashboard == 1){
                List<Author> author = authorDao.getAuthors();
                authorsDashboard.displayAuthors(author);
            }
            else if (chooseAuthorsDashboard == 2){
                System.out.print("Author ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                Author author = authorDao.getSpecificAuthor(id);
                authorsDashboard.displaySpecificAuthor(author);
            }
            else if (chooseAuthorsDashboard == 3){
                System.out.print("Book ID: ");
                int id = scanner.nextInt();
                List<Author> author = authorDao.getAuthorBooks(id);
                authorsDashboard.displayAuthorBooks(author);
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
    }

    public void displayThree(){
        PublishersDashboard publishersDashboard = new PublishersDashboard();
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        PublisherDAO publisherDAO = new PublisherDAOImplementation(database);

        while(true) {
            byte choicePublisherDashboard = publishersDashboard.publishersDashboard(scanner);
            if (choicePublisherDashboard == 1) {
                List<Publisher> publisher = publisherDAO.getPublishers();
                publishersDashboard.displayPublishers(publisher);
            }
            else if (choicePublisherDashboard == 2){
                System.out.print("Publisher ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                Publisher publisher = publisherDAO.getSpecificPublisher(id); // should i do this or
                publishersDashboard.displaySpecificPublisher(publisher);
            }
            else if (choicePublisherDashboard == 3){
                System.out.print("Publisher's ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                publishersDashboard.displayPublisherBooks(publisherDAO.getPublisherBooks(id));
            }
            else if (choicePublisherDashboard == 4){
                Publisher publisher = publishersDashboard.createPublisher(scanner); // should i do this?
                if(publisherDAO.addPublisher(publisher)) System.out.println("Publisher name " + publisher.getName() + " Inserted Successfully");
                else System.out.println("An error has occured");
            }
            else if (choicePublisherDashboard == 5){
                Publisher publisher = publishersDashboard.createUpdatePublisher(scanner);
                if(publisherDAO.updatePublisher(publisher)) System.out.println("Publisher ID " + publisher.getId() + " Updated Successfully");
                else System.out.println("An error has occurred");
            }
            else if (choicePublisherDashboard == 6){
                System.out.print("Publisher ID to be deleted: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                if(publisherDAO.deletePublisher(id)) System.out.println("Publisher ID " + id + " Deleted successfully");
                else System.out.println("An error has occurred");
            }
            else if (choicePublisherDashboard == 7) {
                break;
            }
        }
    }

    public void displayFour(){
        BorrowBooksDashboard borrowBooksDashboard = new BorrowBooksDashboard();
        Scanner scanner = new Scanner(System.in);
        BorrowBookDAO borrowBookDAO = new BorrowBookDAOImplementation();
        AdminDAO adminDAO = new AdminDAOImplementation();

        while(true){
            byte choiceBorrowBookDashboard = borrowBooksDashboard.borrowBooksDashboard(scanner);
            if(choiceBorrowBookDashboard == 1){
                List<BorrowBook> borrowedBooks = borrowBookDAO.borrowedBooks();
                borrowBooksDashboard.displayBorrowedBooks(borrowedBooks);
            }
            else if (choiceBorrowBookDashboard == 2){
                scanner.nextLine();
                System.out.print("Student ID: ");
                String studentId = scanner.nextLine();
                List<BorrowBook> borrowedBook = borrowBookDAO.specificBorrowedBook(studentId);
                borrowBooksDashboard.displayBorrowedBooks(borrowedBook);
            }
            else if (choiceBorrowBookDashboard == 3){
                scanner.nextLine();
                System.out.print("Book ID: ");
                int bookId = scanner.nextInt();
                scanner.nextLine();
                if(borrowBookDAO.checkAvailability(bookId)){
                    BorrowBook borrowBook = booksDashboard.createBorrowBook(scanner, adminDAO);
                    borrowBook.setBookId(bookId);
                    borrowBook.setAdminId(adminDAO.getAdminId());
                    if(borrowBookDAO.borrowBook(borrowBook)) {
                        borrowBookDAO.minusStack(bookId);
                        System.out.println("Book ID: " + bookId + " Successfully borrowed By Student ID: " + borrowBook.getStudentId());
                    }
                    else System.out.println("An error has occurred");
                }
                else System.out.println("Book ID: " + bookId + " has no stocks");

            }
            else if (choiceBorrowBookDashboard == 4){
                break;
            }
        }
    }

    public void displayFive(){
        ReturnBookDashboard returnBookDashboard = new ReturnBookDashboard();
        ReturnBookDAO returnBookDAO = new ReturnBookDAOImplementation();
        Scanner scanner = new Scanner(System.in);
        AdminDAO adminDAO = new AdminDAOImplementation();

        ReturnBook returnBook = returnBookDashboard.displayReturnBook(scanner);
        if(returnBookDAO.checkTransactionId(returnBook.getTransactionId(), returnBook)){
            returnBook = returnBookDAO.returnBook(returnBook, adminDAO.getAdminId());
            if(returnBook != null) {
                returnBookDAO.plusStock(returnBook.getBookId());
                returnBookDAO.updateBook(returnBook.getTransactionId());
                System.out.println("Transaction ID: " + returnBook.getTransactionId() + " Returned Successfully");
            }
        }
        else{
            System.out.println("Transaction ID does not exist");
        }
    }
}
