package Implementation;
import Dao.AdminDAO;
import Dao.BookDAO;
import Database.Database;
import Model.Admin;
import Model.Author;
import Model.Book;
import Model.Publisher;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AdminDAOImplementation implements AdminDAO {
    Database database = new Database();

    @Override
    public void register(Admin admin) {
        String query = "INSERT INTO admins (name, username, password) VALUES (?, ?, ?)";

        if (isUsernameExists(admin.getUsername())) { // does not follow SRP principle
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

    @Override
    public boolean isUsernameExists(String username){
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


    private int id;
    public int getAdminId(){ // for the borrowed_admin_id and the returned_admin_id
        return id; // hindi to dapat nandito
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
                    id = rs.getInt("id");
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
    public Admin validateSuperAdmin(String username, String password){
        String query = "SELECT * FROM admins WHERE username = ? AND id = 1";
        Admin admin = null;
        try(Connection con = database.getConnection();
        PreparedStatement pst = con.prepareStatement(query);){
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();

        if(rs.next()){ // isa lang super admin syug?
            String encryptedPassword = rs.getString("password");
            if(BCrypt.checkpw(password, encryptedPassword)){
                admin = new Admin(rs.getString("name"), username, encryptedPassword);
            }
        }


        }
        catch (Exception e){
            e.printStackTrace();
        }

        return admin;
    }


}
