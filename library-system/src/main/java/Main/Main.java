package Main;

import Dao.AuthorDAO;
import Dao.BookDAO;
import Database.Database;
import Implementation.AuthorDAOImplementation;
import Implementation.BookDAOImplementation;
import Model.Author;
import Model.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        BookDAO bookDao = new BookDAOImplementation(database);
        AuthorDAO authorDao = new AuthorDAOImplementation();

        Author author1 = new Author("Kendrick Lamar", "lamar@gmail.com");
        Book book1 = new Book("money trees", "music", "2024-12-02", 10, 7, 3);

        List<Author> authors = authorDao.getAuthorBooks(7);

        int i = 0;
        for(Author author : authors){
            if(i == 0){
                System.out.println("---------------------------------------");
                System.out.println("|| Author's name: " + author.getName() + "     ||");
                System.out.println("|| Email: " + author.getEmail() + "            ||");
                System.out.println("---------------------------------------");
                i++;
            }
            System.out.println(author.getBooks());
            System.out.println("---------------------------");
        }

/*
        List<Book> books = bookDao.getBooks();
        for(Book book : books){
            System.out.println("Book ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Year: " + book.getYear());
            System.out.println("Stock: " + book.getStock());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("--------------");
        }

 */





        /*
        List<Author> authors = authorDao.getAuthors();
        for(Author author : authors) {
            System.out.println("Author ID: " + author.getId());
            System.out.println("Name: " + author.getName());
            System.out.println("Email: " + author.getEmail());
            System.out.println("--------------");
        }

         */








    }
}
