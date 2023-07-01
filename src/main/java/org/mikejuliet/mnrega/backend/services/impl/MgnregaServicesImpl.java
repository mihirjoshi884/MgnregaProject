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
    private HelpingServicesImpl helpingServices = new HelpingServicesImpl();
    private MgnregaUserRepositoryImpl userRepository = new MgnregaUserRepositoryImpl();
    private MgnregaEmployeeRepositoryImpl employeeRepository = new MgnregaEmployeeRepositoryImpl();
    private MgnregaProjectRepositoryImpl projectRepository = new MgnregaProjectRepositoryImpl();
    private ProjectResult projectResult = new ProjectResult();
    private MgnregaInterEntityRepository entityRepository = new MgnregaInterEntityRepository();

    public boolean createAccount(Users user) {
        if(user != null){
            if(user.getUserType().equals("BDO")){
                user.setUser_code(helpingServices.BDOuser_code(user.getId()));
            }
            else user.setUser_code(helpingServices.GPMuser_code(user.getId()));
            userRepository.createUser(user);
            return true ;
        }

        return false;
    }

    public boolean loginAccount(String username, String password) throws SQLException {
        Users result = userRepository.findUserByUsername(username);

        if((result.getUsername()==username)&&(result.getPassword()==helpingServices.passwordProtection(password))){
            return true;
        }
        else return false;

    }


    public Employee assignProjectToEmployee(Employee employee, String projectName) throws SQLException {

        //method for assigning project to Employees
        employee.setEmp_code(helpingServices.employeeCode(employee.getEmp_code(),projectName));
        Employee result = projectRepository.getProjectCode(projectName);
        employee.setProject_code(result.getProject_code());
        return employee;
    }

    public boolean createEmployee(Employee employee) {
        if(employee!=null){
            //generating random employee id for employee_code
            Random random = new Random();
            int empId = random.nextInt(9000) + 1000;
            employee.setEmp_code(helpingServices.employeeCode(empId));
            employeeRepository.createEmployee(employee);
            return true;
        }
        else return false;
    }

    public boolean createProject(Project project) {
        //generating random project value
        Random random = new Random();
        int projId = random.nextInt(9000)+1000;
        project.setProject_code(helpingServices.project_code(projId,project.getProject_name()));
        projectRepository.createProject(project);
        return true;
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

    public boolean createGPMuser(Users user) {
        user.setUserType("GPM");
        if(createAccount(user)==true) return true;;
        return false;
    }

    public boolean createBDOuser(Users user) {
        user.setUserType("BDO");
        if(createAccount(user)==true) return true;;
        return false;
    }

    public UserProjectResult allocateProjectToGPM(Users user, ProjectResult project) {
        UserProjectResult response = entityRepository.setFeilds(user,project);
        return response;
    }

    public EmployeeResult showEmployeeDetails(Employee employee) throws SQLException {
        Employee emp_result = employeeRepository.findEmployeeByUsername(employee.getUsername());
        EmployeeResult result = employeeRepository.showEmployeeDetails(emp_result);
        return result;
    }

    public UserResult getGPMuser(Users user) throws SQLException {
        return userRepository.findGpmUserById(user);
    }

    public UserResult getBDOuser(Users user) throws SQLException {
        return userRepository.findBDOUserById(user);
    }

    public ProjectResult getProjectDetails(String projectName) throws SQLException {
        ProjectResult result = projectRepository.findProjectDetails(projectName);
        return result;
    }

    public Employee getEmployeeDetails(String username) throws SQLException {
        Employee result = employeeRepository.findEmployeeByUsername(username);
        return result;
    }


}
