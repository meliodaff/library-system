package Main;
import Dao.AdminDAO;
import Dao.BookDAO;
import Database.Database;
import Model.Admin;
import Implementation.BookDAOImplementation;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class AdminDAOImplementation implements AdminDAO {
    Database database = new Database();
    BookDAO bookDao = new BookDAOImplementation(database);

    Scanner scanner = new Scanner(System.in);

    @Override
    public void frontDashboard(){
        System.out.println("Welcome to book buddy");
        System.out.println("[1] Login");
        System.out.println("[2] Register");
        String input = scanner.nextLine();
        int user = Integer.parseInt(input);
        if(user == 1){
            loginDashboard();
        }
        else if (user == 2){
            registerDashboard();
        }
    }

    //Admin admin = null;
    @Override
    public void loginDashboard(){
        System.out.println("Book Buddy");
        System.out.println("Login");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
    }

    public void registerDashboard(){
        System.out.print("Name:");
        String name = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

    }

    @Override
    public void adminDashboard(){
        System.out.println("Book Buddy");
        System.out.println("[1] Books");
        System.out.println("[2] Authors");
        System.out.println("[3] Publishers");
    }

    @Override
    public Admin logIn(String username, String password){
        String query = "SELECT * FROM admins WHERE username = ?";

        try(Connection con = database.getConnection();
            PreparedStatement pst = con.prepareStatement(query)){

            pst.setString(1, username);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                String encryptedPassword = rs.getString("password");
                if(BCrypt.checkpw(password, encryptedPassword)){
                    System.out.println("Login Successfully");
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



        return null;
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
