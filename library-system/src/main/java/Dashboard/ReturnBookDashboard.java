package Dashboard;

import Dao.AdminDAO;
import Implementation.AdminDAOImplementation;
import Model.Admin;
import Model.ReturnBook;

import javax.lang.model.type.ReferenceType;
import java.util.Scanner;

public class ReturnBookDashboard {

    AdminDAO adminDAO = new AdminDAOImplementation();

    public ReturnBook displayReturnBook(Scanner scanner, ReturnBook returnBook){
        System.out.print("Transaction ID: ");
        int transactionId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Condition: ");
        String condition = scanner.nextLine();
        returnBook = new ReturnBook(adminDAO.getAdminId(), transactionId, condition);
        return returnBook;
    }
}
