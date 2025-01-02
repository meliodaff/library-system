package Implementation;

import Dao.ReturnBookDAO;
import Database.Database;
import Model.ReturnBook;
import Dao.AdminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReturnBookDAOImplementation implements ReturnBookDAO {
    Database database = new Database();
    AdminDAO adminDAO = new AdminDAOImplementation();

    @Override
    public ReturnBook returnBook(ReturnBook returnBook, int adminId) {
        String query = "INSERT INTO return_table (transaction_id, `condition`, returned_admin_id) VALUES (?, ?, ?)";

        try (Connection con = database.getConnection();
             PreparedStatement pst = con.prepareStatement(query);) {
            pst.setInt(1, returnBook.getTransactionId());
            pst.setString(2, returnBook.getCondition());
            pst.setInt(3, adminId);
            //returnBook = new ReturnBook(returnBook.getTransactionId(), returnBook.getCondition(), adminDAO.getAdminId());
            //returnBook.setAdminId(adminDAO.getAdminId());
            pst.executeUpdate();
            return returnBook;
        } catch (Exception e) {
            System.out.printf("im here");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkTransactionId(int transactionId, ReturnBook returnBook) {
        String query = "SELECT id, book_id FROM transaction_table WHERE id = ? AND remarks = 'BORROWED'";

        try (Connection con = database.getConnection();
             PreparedStatement pst = con.prepareStatement(query);) {
            pst.setInt(1, transactionId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                returnBook.setBookId(rs.getInt("book_id"));
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void plusStock(int bookId) {
        String query = "UPDATE books SET stock = stock + 1 WHERE id = ?";

        try (Connection con = database.getConnection();
             PreparedStatement pst = con.prepareStatement(query);) {
            pst.setInt(1, bookId);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateBook(int transactionId){
        String query = "UPDATE transaction_table SET remarks = 'RETURNED' WHERE id = ?";

        try(Connection con = database.getConnection();
        PreparedStatement pst = con.prepareStatement(query);){
            pst.setInt(1, transactionId);
            pst.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
