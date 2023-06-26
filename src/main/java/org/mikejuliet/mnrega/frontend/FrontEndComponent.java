package org.mikejuliet.mnrega.frontend;

import org.mikejuliet.mnrega.backend.entities.Users;
import org.mikejuliet.mnrega.backend.entities.helpingResult.UserResult;
import org.mikejuliet.mnrega.backend.repository.repoimpl.MgnregaUserRepositoryImpl;
import org.mikejuliet.mnrega.backend.services.impl.HelpingServicesImpl;
import org.mikejuliet.mnrega.backend.services.impl.MgnregaServicesImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class FrontEndComponent {
    String username = null;
    String password = null;
    private HelpingServicesImpl helpingServices;
    private MgnregaServicesImpl services;
    private MgnregaUserRepositoryImpl userRepository;

    public void userProfile(UserResult user){

    }
    public void login() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to project MGNREGA");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("enter username:");
        String username = scanner.nextLine();
        String password = helpingServices.passwordProtection(scanner.nextLine());
        System.out.println("are you BDO or GPM ??");
        String user_type = scanner.nextLine();

        boolean result = services.loginAccount(username,password);

        if((user_type == "BDO") && (result == true)){
            userProfile(services.getBDOuser(userRepository.findUserByUsername(username)));
        }
        else if((user_type == "GPM")&&(result == true)){
            userProfile(services.getGPMuser(userRepository.findUserByUsername(username)));
        }
        else {
            for(int i=0;i<5;i++){
                login();
            }
        }


    }

}
