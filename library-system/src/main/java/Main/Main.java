package Main;

import Dao.AdminDAO;
import Dashboard.DisplayDashboards;
import Dashboard.LogInDashboard;
import Implementation.AdminDAOImplementation;
import Model.Admin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AdminDAO adminDAO = new AdminDAOImplementation();
        DisplayDashboards displayDashboards = new DisplayDashboards();
        LogInDashboard logInDashboard = new LogInDashboard();
        Scanner scanner = new Scanner(System.in);

        while(true){
        int chooseDashboard = logInDashboard.frontDashboard(scanner);
        if(chooseDashboard == 1){
            if (logInDashboard.loginDashboard(scanner, adminDAO) == null) {
                return;
            }
            System.out.println("Login successful!");
            while(true) {
                byte choiceAdminDashboard = logInDashboard.adminDashboard(scanner);
                if (choiceAdminDashboard == 1) {
                    displayDashboards.displayOne();
                }
                else if (choiceAdminDashboard == 2) {
                    displayDashboards.displayTwo();
                }
                else if (choiceAdminDashboard == 3) {
                    displayDashboards.displayThree();
                }
                else if (choiceAdminDashboard == 4) {
                    displayDashboards.displayFour();
                }
                else if (choiceAdminDashboard == 5){
                    displayDashboards.displayFive();
                }
                else if (choiceAdminDashboard == 6){
                    break;
                }
            }
        }
        else if (chooseDashboard == 2){
            Admin admin = logInDashboard.displaySuperAdmin(scanner);
            if(adminDAO.validateSuperAdmin(admin.getUsername(), admin.getPassword()) != null){
                logInDashboard.registerDashboard(adminDAO ,scanner);
            }
            else System.out.println("Wrong Super Admin");

        }
        }

    }
}
