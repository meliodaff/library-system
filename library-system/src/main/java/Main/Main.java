package Main;

import Dao.AdminDAO;
import Dashboard.DisplayDashboards;
import Implementation.AdminDAOImplementation;

public class Main {
    public static void main(String[] args) {

        AdminDAO adminDAO = new AdminDAOImplementation();

        DisplayDashboards displayDashboards = new DisplayDashboards();

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
            adminDAO.registerDashboard();
        }
        }

    }
}
