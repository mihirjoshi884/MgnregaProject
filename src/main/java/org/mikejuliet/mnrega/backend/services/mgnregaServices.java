package org.mikejuliet.mnrega.backend.services;

import org.mikejuliet.mnrega.backend.entities.Employee;
import org.mikejuliet.mnrega.backend.entities.Project;
import org.mikejuliet.mnrega.backend.entities.Users;
import org.mikejuliet.mnrega.backend.entities.helpingResult.EmployeeResult;
import org.mikejuliet.mnrega.backend.entities.helpingResult.UserProjectResult;

import java.sql.SQLException;

public interface mgnregaServices {
    public void createAccount(Users user);
    public Users loginAccount(Users user,String username,String password);
    public Employee assignProjectToEmployee(Employee employee,String projectName) throws SQLException;
    public void createEmployee(Employee employee);
    public void createProject(Project project);
    public void showProjectList() throws SQLException;
    public void showGPMlist() throws SQLException;
    public void showGPMdetails(Users user) throws SQLException;
    public void createGPMuser(Users user);
    public void createBDOuser(Users user);
    public UserProjectResult allocateProjectToGPM(Users user, Project project);
    public EmployeeResult showEmployeeDetails(Employee employee) throws SQLException;
}