package Implementation;
import Dao.AdminDAO;
import Dao.BookDAO;
import Database.Database;
import Model.Admin;
import Model.Book;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;
public class AdminDAOImplementation implements AdminDAO {
    Database database = new Database();
    BookDAO bookDao = new BookDAOImplementation(database);

    Scanner scanner = new Scanner(System.in);

    @Override
    public byte frontDashboard(){
        System.out.println("Welcome to book buddy");
        System.out.println("[1] Login");
        System.out.println("[2] Register");
        byte choice = scanner.nextByte();
        scanner.nextLine();
        return choice;
    }

    //Admin admin = null;
    @Override
    public Admin loginDashboard(){
        System.out.println("Book Buddy");
        System.out.println("Login");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        Admin admin = logIn(username, password);
        return admin;
    }

    @Override
    public void registerDashboard(){
        System.out.print("Name:");
        String name = scanner.nextLine().toLowerCase();
        System.out.print("Username: ");
        String username = scanner.nextLine().toLowerCase();
        System.out.print("Password: ");
        String password = scanner.nextLine().toLowerCase();
        Admin admin = new Admin(name, username, password);
        register(admin);

    }

    @Override
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

    @Override
    public byte adminDashboard(){
        System.out.println("Book Buddy");
        System.out.println("[1] Books");
        System.out.println("[2] Authors");
        System.out.println("[3] Publishers");
        System.out.println("[4] Logout");
        byte choice = scanner.nextByte();
        return choice;
    }

    public byte booksDashboard(){
            System.out.println("Books");
            System.out.println("[1] View Books");
            System.out.println("[2] View Specific Book");
            System.out.println("[3] Add Book");
            System.out.println("[4] Update Book");
            System.out.println("[5] Delete Book");
            System.out.println("[6] Back");
            return scanner.nextByte();

    }

    public void authorsDashboard(){
        System.out.println("Authors");
    }

    public void publishersDashboard(){
        System.out.println("Publishers");
    }



    @Override
    public Admin logIn(String username, String password){
        String query = "SELECT * FROM admins WHERE username = ?";
        Admin admin = null;
        try(Connection con = database.getConnection();
            PreparedStatement pst = con.prepareStatement(query)){

            pst.setString(1, username);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                String encryptedPassword = rs.getString("password");
                if(BCrypt.checkpw(password, encryptedPassword)){
                    admin = new Admin(rs.getString("name"), username, encryptedPassword);
                }
                else{
                    System.out.println("Invalid Password");
                }
            }
            else{
                System.out.println("Username doesnt exist");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }
    @Override
    public void register(Admin admin) {
        String query = "INSERT INTO admins (name, username, password) VALUES (?, ?, ?)";

        if (isUsernameExists(admin.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        try(Connection con = database.getConnection();
        PreparedStatement pst = con.prepareStatement(query);){
            String encryptedPassword = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt(12));
            pst.setString(1, admin.getName());
            pst.setString(2, admin.getUsername());
            pst.setString(3, encryptedPassword);

            int rowsInserted = pst.executeUpdate();

            if(rowsInserted > 0){
                System.out.println("Registered Successfully");
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean isUsernameExists(String username){
        String query = "SELECT COUNT(*) count FROM admins WHERE username = ?";

        try(Connection connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int count = resultSet.getInt("count");
                if(count > 0){
                    return true;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
