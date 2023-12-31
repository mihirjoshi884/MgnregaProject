package org.mikejuliet.mnrega.backend.services;

import org.mikejuliet.mnrega.backend.entities.Employee;
import org.mikejuliet.mnrega.backend.entities.Project;
import org.mikejuliet.mnrega.backend.entities.Users;
import org.mikejuliet.mnrega.backend.entities.helpingResult.EmployeeResult;
import org.mikejuliet.mnrega.backend.entities.helpingResult.ProjectResult;
import org.mikejuliet.mnrega.backend.entities.helpingResult.UserProjectResult;
import org.mikejuliet.mnrega.backend.entities.helpingResult.UserResult;

import java.sql.SQLException;

public interface mgnregaServices {
    public boolean createAccount(Users user);
    public boolean loginAccount(String username, String password) throws SQLException;
    public Employee assignProjectToEmployee(Employee employee,String projectName) throws SQLException;
    public boolean createEmployee(Employee employee);
    public boolean createProject(Project project);
    public void showProjectList() throws SQLException;
    public void showGPMlist() throws SQLException;
    public void showGPMdetails(Users user) throws SQLException;
    public boolean createGPMuser(Users user);
    public boolean createBDOuser(Users user);
    public UserProjectResult allocateProjectToGPM(Users user, ProjectResult project);
    public EmployeeResult showEmployeeDetails(Employee employee) throws SQLException;
    public UserResult getGPMuser(Users user) throws SQLException;
    public UserResult getBDOuser(Users user) throws SQLException;
    public ProjectResult getProjectDetails(String projectName) throws SQLException;
    public Employee getEmployeeDetails(String username) throws SQLException;
}
