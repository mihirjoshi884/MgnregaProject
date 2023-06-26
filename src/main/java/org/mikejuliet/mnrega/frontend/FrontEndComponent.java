package org.mikejuliet.mnrega.frontend;

import lombok.var;
import org.mikejuliet.mnrega.backend.entities.Employee;
import org.mikejuliet.mnrega.backend.entities.Project;
import org.mikejuliet.mnrega.backend.entities.Users;
import org.mikejuliet.mnrega.backend.entities.helpingResult.EmployeeResult;
import org.mikejuliet.mnrega.backend.entities.helpingResult.ProjectResult;
import org.mikejuliet.mnrega.backend.entities.helpingResult.UserProjectResult;
import org.mikejuliet.mnrega.backend.entities.helpingResult.UserResult;
import org.mikejuliet.mnrega.backend.repository.repoimpl.MgnregaEmployeeRepositoryImpl;
import org.mikejuliet.mnrega.backend.repository.repoimpl.MgnregaUserRepositoryImpl;
import org.mikejuliet.mnrega.backend.services.impl.HelpingServicesImpl;
import org.mikejuliet.mnrega.backend.services.impl.MgnregaServicesImpl;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import static java.time.LocalDate.*;

public class FrontEndComponent {
    String username = null;
    String password = null;
    static Scanner scanner = new Scanner(" ");
    private HelpingServicesImpl helpingServices;
    private MgnregaServicesImpl services;
    private MgnregaUserRepositoryImpl userRepository;
    private MgnregaEmployeeRepositoryImpl repository ;

    public void GPMuserProfile(UserResult user) throws SQLException {
        System.out.println("welcome "+user.getName()+"to MGNREGA");
        System.out.println("user type of the user"+user.getUser_type());
        int choice = -1;
        while(choice!=0){
            System.out.println("0. quit 1. user information 2.create employee  3. allocate project to employee");
            System.out.print("enter your choice:");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("user code of GPM  is :\t"+user.getUser_code());
                    System.out.println("name of the GPM is:\t"+user.getName());
                    System.out.println("email of the GPM is:\t"+user.getEmail());
                    System.out.println("phone number of the GPM is:\t"+user.getPhone());
                    System.out.println("salary of the GPM is: \t"+user.getSalary());
                    System.out.println("tenure of the GPM is:\t"+user.getTenure());
                    break;
                case 2:
                    Employee employee = null;
                    System.out.println("enter following data for employee:");
                    //user input for the employee
                    System.out.println("enter first name of the employee:\t");
                    employee.setFirstName(scanner.nextLine());
                    System.out.println("enter last name of the employee:\t");
                    employee.setLastName(scanner.nextLine());
                    System.out.println("enter phone number of the employee:\t");
                    employee.setPhone_number(scanner.nextInt());
                    System.out.println("enter email of the employee");
                    employee.setEmail(scanner.nextLine());
                    System.out.println("enter joining datae (yyyy-MM-dd) of the employee:\t");
                    String date1 = scanner.nextLine();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    try {
                        date = dateFormat.parse(date1);
                        System.out.println("Entered date: " + date);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
                    }
                    employee.setJoiningDate(date);
                    System.out.println("what is the type of employee(daily wage worker/contractual worker):\t");
                    employee.setEmp_type(scanner.nextLine());
                    System.out.println("enter username for employee:\t");
                    employee.setUsername(scanner.nextLine());
                    System.out.println("enter password for employee:\t");
                    employee.setPassword(helpingServices.passwordProtection(scanner.nextLine()));
                    if(services.createEmployee(employee)==true){
                        System.out.println("employee is successfully created");
                    }
                    break;
                case 3:
                    //project allocation
                    System.out.println("enter the username of the user");
                    String username = scanner.nextLine();
                    System.out.println("enter the project name which you want to assign");
                    String project = scanner.nextLine();
                    EmployeeResult employeeResult = null;
                    ProjectResult projectResult = null;
                    projectResult = services.getProjectDetails(project);

                    employee = repository.findEmployeeByUsername(username);
                    employeeResult = services.showEmployeeDetails(employee);
                    services.assignProjectToEmployee(employee,project);
                    System.out.println("project is assigned to user:\t");
                    break;

            }
        }
    }
    public void BDOuserProfile(UserResult user) throws SQLException {
        System.out.println("welcome "+user.getName()+"to MGNREGA");
        System.out.println("user type of the user"+user.getUser_type());
        int choice = -1;
        while(choice!=0){
            System.out.println("0. to quit 1. user information 2.create GPM 3.create project 4. allocate project to GPM");
            System.out.print("enter your choice:");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("user code of BDO  is :\t"+user.getUser_code());
                    System.out.println("name of the BDO is:\t"+user.getName());
                    System.out.println("email of the BDO is:\t"+user.getEmail());
                    System.out.println("phone number of the BDO is:\t"+user.getPhone());
                    System.out.println("salary of the BDO is: \t"+user.getSalary());
                    System.out.println("tenure of the BDO is:\t"+user.getTenure());
                    break;
                case 2:
                    Users userInputData = null;
                    //user input from BDO
                    System.out.println("enter following details for GMP");
                    System.out.print("enter the first name of:\t");
                    userInputData.setFirst_name(scanner.nextLine());
                    System.out.print("enter the last name of\t");
                    userInputData.setLast_name(scanner.nextLine());
                    System.out.print("enter the username for:\t");
                    userInputData.setUsername(scanner.nextLine());
                    System.out.print("enter the password for:\t");
                    userInputData.setPassword(scanner.nextLine());
                    System.out.print("enter tenure of GPM:\t");
                    userInputData.setTenure(scanner.nextInt());
                    System.out.print("enter salary of GPM:\t");
                    userInputData.setSalary(scanner.nextInt());
                    System.out.print("enter email of GPM:\t");
                    userInputData.setEmail(scanner.nextLine());
                    System.out.print("enter phone number of the user:\t");
                    userInputData.setPhone(scanner.nextInt());
                    System.out.print("enter four digit id:\t");
                    userInputData.setId(scanner.nextInt());
                    //creating GPM user
                    if(services.createGPMuser(userInputData)==true) System.out.println("GPM user is created");
                    else System.out.println("there is some mistake");
                    break;
                case 3:
                    //create project
                    Project project = new Project();
                    System.out.println("enter project details");
                    System.out.println("enter project name:\t");
                    project.setProject_name(scanner.nextLine());
                    System.out.println("enter the number of the vacancy:\t");
                    project.setVacancy(scanner.nextInt());
                    System.out.println("enter the region of the project:\t");
                    project.setRegion(scanner.nextLine());
                    System.out.println("enter the state where project is:\t");
                    project.setState(scanner.nextLine());
                    System.out.println("enter the domain of the project is:\t");
                    project.setDomain(scanner.nextLine());
                    if(services.createProject(project)==true) System.out.println("project created successfully");
                    else System.out.println("something went wrong");
                    break;
                case 4:
                    //allocated project to GPM
                    System.out.println("enter username of GPM:\t");
                    String username = scanner.nextLine();
                    Users GPMuser = userRepository.findUserByUsername(username);
                    System.out.println("enter name of the project");
                    String project_name = scanner.nextLine();
                    ProjectResult proj = services.getProjectDetails(project_name);
                    UserProjectResult projectResult = services.allocateProjectToGPM(GPMuser,proj);
                    System.out.println("project allocated successfully to GPM");
                    break;
            }
        }
    }
    public void login() throws SQLException {

        System.out.println("welcome to project MGNREGA");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("enter username:");
        String username = scanner.nextLine();
        String password = helpingServices.passwordProtection(scanner.nextLine());
        System.out.println("are you BDO or GPM ??");
        String user_type = scanner.nextLine();

        boolean result = services.loginAccount(username,password);

        if((user_type == "BDO") && (result == true)){
            BDOuserProfile(services.getBDOuser(userRepository.findUserByUsername(username)));
        }
        else if((user_type == "GPM")&&(result == true)){
            GPMuserProfile(services.getGPMuser(userRepository.findUserByUsername(username)));
        }
        else {
            for(int i=0;i<5;i++){
                login();
            }
        }


    }
    public void createBDOaccount(){
        Users userInputData = new Users();
        //user input from BDO
        System.out.println("enter following details for BDO");
        System.out.print("enter the first name :\t");
        userInputData.setFirst_name(scanner.nextLine());
        System.out.print("enter the last name \t");
        userInputData.setLast_name(scanner.nextLine());
        System.out.print("enter the username :\t");
        userInputData.setUsername(scanner.nextLine());
        System.out.print("enter the password :\t");
        userInputData.setPassword(scanner.nextLine());
        System.out.print("enter tenure of BDO:\t");
        userInputData.setTenure(scanner.nextInt());
        System.out.print("enter salary of BDO:\t");
        userInputData.setSalary(scanner.nextInt());
        System.out.print("enter email of BDO:\t");
        userInputData.setEmail(scanner.nextLine());
        System.out.print("enter phone number:\t");
        userInputData.setPhone(scanner.nextInt());
        System.out.print("enter four digit id:\t");
        userInputData.setId(scanner.nextInt());
        //creating BDO user
        if(services.createBDOuser(userInputData)==true) System.out.println("BDO user is created");
        else System.out.println("there is some mistake");

    }
    public void employeeLogin() throws SQLException {
        System.out.println("welcome employee to MGNREGA");
        System.out.println("enter username:");
        username = scanner.nextLine();
        System.out.println("enter password");
        password = helpingServices.passwordProtection(scanner.nextLine());

        Employee result = services.getEmployeeDetails(username);
        if(result != null && username == result.getUsername() && password == result.getPassword()){
            employeeUserProfile(result);
        }
        else {
            for(int i=0;i<5;i++){
                login();
            }

        }
    }

    private void employeeUserProfile(Employee result) {
        System.out.println("welcome to MGNREGA ");
        System.out.println("employee code is:"+result.getEmp_code());
        System.out.println("name of the employee-\t"+result.getFirstName()+result.getLastName());
        System.out.println("employee type-\t"+result.getEmp_type());
        System.out.println("phone number of the employee-\t"+result.getPhone_number());
        System.out.println("email of the employee"+result.getEmail());
        System.out.println("employee is currently working on the project whose project code is:\t"+result.getProject_code());
    }

}
