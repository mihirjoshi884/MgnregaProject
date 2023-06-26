package org.mikejuliet.mnrega.backend.services.impl;

import org.mikejuliet.mnrega.backend.entities.Employee;
import org.mikejuliet.mnrega.backend.entities.Project;
import org.mikejuliet.mnrega.backend.entities.Users;
import org.mikejuliet.mnrega.backend.entities.helpingResult.EmployeeResult;
import org.mikejuliet.mnrega.backend.entities.helpingResult.UserProjectResult;
import org.mikejuliet.mnrega.backend.repository.inter_entityRepository.impl.MgnregaInterEntityRepository;
import org.mikejuliet.mnrega.backend.repository.repoimpl.MgnregaEmployeeRepositoryImpl;
import org.mikejuliet.mnrega.backend.repository.repoimpl.MgnregaProjectRepositoryImpl;
import org.mikejuliet.mnrega.backend.repository.repoimpl.MgnregaUserRepositoryImpl;
import org.mikejuliet.mnrega.backend.entities.helpingResult.ProjectResult;
import org.mikejuliet.mnrega.backend.entities.helpingResult.UserResult;
import org.mikejuliet.mnrega.backend.services.mgnregaServices;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class MgnregaServicesImpl implements mgnregaServices {
    private HelpingServicesImpl helpingServices;
    private MgnregaUserRepositoryImpl userRepository;
    private MgnregaEmployeeRepositoryImpl employeeRepository;
    private MgnregaProjectRepositoryImpl projectRepository;
    private ProjectResult projectResult;
    private MgnregaInterEntityRepository entityRepository;

    public void createAccount(Users user) {
        if(user != null){
            if(user.getUserType()=="Block Development Officer"){
                user.setUser_code(helpingServices.BDOuser_code(user.getId()));
            }
            else user.setUser_code(helpingServices.GPMuser_code(user.getId()));

            String password = helpingServices.passwordProtection(user.getPassword());
            user.setPassword(password);
            userRepository.createUser(user);
            System.out.println("user created");
        }

    }

    public Users loginAccount(Users user,String username, String password) {
        Users result = userRepository.findUserByUsername(user);

        if((result.getUsername()==username)&&(result.getPassword()==helpingServices.passwordProtection(password))){
            System.out.println("login successful");
        }
        else System.out.println("login fail");
        return null;
    }


    public Employee assignProjectToEmployee(Employee employee, String projectName) throws SQLException {

        //method for assigning project to Employees
        employee.setEmp_code(helpingServices.employeeCode(employee.getEmp_code(),projectName));
        Employee result = projectRepository.getProjectCode(projectName);
        employee.setProject_code(result.getProject_code());
        return employee;
    }

    public void createEmployee(Employee employee) {

        //generating random employee id for employee_code
        Random random = new Random();
        int empId = random.nextInt(9000) + 1000;
        employee.setEmp_code(helpingServices.employeeCode(empId));
        String protectedPwd = helpingServices.passwordProtection(employee.getPassword());
        employee.setPassword(protectedPwd);
        employeeRepository.createEmployee(employee);
    }

    public void createProject(Project project) {
        //generating random project value
        Random random = new Random();
        int projId = random.nextInt(9000)+1000;
        project.setProject_code(helpingServices.project_code(projId,project.getProject_name()));
        projectRepository.createProject(project);
    }

    public void showProjectList() throws SQLException {
        List<ProjectResult> result = projectRepository.getListOfProjects();
        System.out.println(result.iterator().next());
    }

    public void showGPMlist() throws SQLException {
        List<UserResult> results = userRepository.findAllGpmUsers();
        System.out.println(results.iterator().next());
    }

    public void showGPMdetails(Users user) throws SQLException {
        UserResult result = userRepository.findGpmUserById(user);
        System.out.println(user);
    }

    public void createGPMuser(Users user) {
        user.setUserType("GPM");
        createAccount(user);
    }

    public void createBDOuser(Users user) {
        user.setUserType("BDO");
        createAccount(user);
    }

    public UserProjectResult allocateProjectToGPM(Users user, Project project) {
        UserProjectResult response = entityRepository.setFeilds(user,project);
        return response;
    }

    public EmployeeResult showEmployeeDetails(Employee employee) throws SQLException {
        Employee emp_result = employeeRepository.findEmployeeByUsername(employee.getUsername());
        EmployeeResult result = employeeRepository.showEmployeeDetails(emp_result);
        return result;
    }


}
