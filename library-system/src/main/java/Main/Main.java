package Main;

import Dao.AdminDAO;
import Dashboard.DisplayDashboards;
import Implementation.AdminDAOImplementation;
import Model.Admin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AdminDAO adminDAO = new AdminDAOImplementation();

        DisplayDashboards displayDashboards = new DisplayDashboards();
        Scanner scanner = new Scanner(System.in);

        while(true){
        int chooseDashboard = adminDAO.frontDashboard();
        if(chooseDashboard == 1){
            if (adminDAO.loginDashboard() == null) {
                return;
            }
            System.out.println("Login successful!");
            while(true) {
                byte choiceAdminDashboard = adminDAO.adminDashboard();
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
            Admin admin = adminDAO.displaySuperAdmin(scanner);
            if(adminDAO.validateSuperAdmin(admin.getUsername(), admin.getPassword()) != null){
                adminDAO.registerDashboard();
            }
            else System.out.println("Wrong Super Admin");

        }
        }

    }
}
