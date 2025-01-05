package Dashboard;

import Dao.AdminDAO;
import Implementation.AdminDAOImplementation;
import Model.ReturnBook;
import java.util.Scanner;

public class ReturnBookDashboard {

    AdminDAO adminDAO = new AdminDAOImplementation();

    public ReturnBook displayReturnBook(Scanner scanner){
        System.out.print("Transaction ID: ");
        int transactionId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Condition: ");
        String condition = scanner.nextLine();
        ReturnBook returnBook = new ReturnBook(adminDAO.getAdminId(), transactionId, condition);
        return returnBook;
    }
}
