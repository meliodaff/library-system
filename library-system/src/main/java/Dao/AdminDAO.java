package Dao;
import Model.Admin;
import Model.Author;
import Model.Book;
import Model.Publisher;

import java.util.List;

public interface AdminDAO {
    void register(Admin admin);
    Admin logIn(String username, String password);
    Admin loginDashboard();
    byte adminDashboard();
    byte frontDashboard();
    byte booksDashboard();
    byte authorsDashboard();
    byte publishersDashboard();
    void displayBooks(List<Book> books);
    void displayAuthors(List<Author> authors);
    void displaySpecificAuthor(Author author);
    void displayAuthorBooks(List<Author> author);
    void displayPublishers(List<Publisher> publishers);
    void displaySpecificPublisher(Publisher publisher);
    void displayPublisherBooks(List<Publisher> publisher);
    void registerDashboard();
}
