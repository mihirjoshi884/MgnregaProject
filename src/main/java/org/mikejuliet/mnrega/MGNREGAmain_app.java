package org.mikejuliet.mnrega;

import org.mikejuliet.mnrega.frontend.FrontEndComponent;

import java.sql.SQLException;
import java.util.Scanner;

public class MGNREGAmain_app {
    public static FrontEndComponent frontEnd = new FrontEndComponent();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        int choice = -1;
        while(choice !=0){
            System.out.println("0. to quit 1. to login as BDO/GPM 2. to login as employee 3. for BDO to signUP");
            System.out.println("enter your choice");
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    frontEnd.login();
                    break;
                case 2:
                    frontEnd.employeeLogin();
                    break;
                case 3:
                    frontEnd.createBDOaccount();
                    break;
            }
        }
    }
}
