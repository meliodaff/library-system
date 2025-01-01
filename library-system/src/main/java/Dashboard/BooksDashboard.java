package Dashboard;
import Model.Book;

import java.util.List;
import java.util.Scanner;
public class BooksDashboard {
    Scanner scanner = new Scanner(System.in);

    public byte booksDashboard(){
        System.out.println("++ Books ++");
        System.out.println("[1] View Books");
        System.out.println("[2] View Specific Book");
        System.out.println("[3] Add Book");
        System.out.println("[4] Update Book");
        System.out.println("[5] Delete Book");
        System.out.println("[6] Back");
        System.out.println("-------------------------");
        byte choice = scanner.nextByte();
        scanner.nextLine();
        return choice;
    }

    public void displayBooks(List<Book> books){
        for(Book book : books){
            System.out.println("Book ID: " + book.getId());
            System.out.println("Book title: " + book.getTitle());
            System.out.println("Book genre: " + book.getGenre());
            System.out.println("Year: " + book.getYear());
            System.out.println("Stock: " + book.getStock());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("-----------------------------------");
        }
    }
}
