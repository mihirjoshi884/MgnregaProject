package org.mikejuliet.mnrega.backend.repository.repoimpl;

import org.mikejuliet.mnrega.backend.config.DatabaseConfiguration;
import org.mikejuliet.mnrega.backend.config.DatabaseConnector;
import org.mikejuliet.mnrega.backend.entities.Employee;
import org.mikejuliet.mnrega.backend.entities.Project;
import org.mikejuliet.mnrega.backend.repository.mgnregaProjectRepository;
import org.mikejuliet.mnrega.backend.entities.helpingResult.ProjectResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MgnregaProjectRepositoryImpl implements mgnregaProjectRepository {
    private  String sqlStatment;
    private final DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
    private final DatabaseConnector connector = new DatabaseConnector();


    public void createProject(Project project) {
        sqlStatment = "INSERT INTO " +
                "project(project_code,project_name,vacancy,region,state,domain)" +
                "VALUES("+project.getProject_code()+"," +
                project.getProject_name()+","+
                project.getVacancy()+","+
                project.getRegion()+"," +
                project.getState()+","+
                project.getState()+","+
                project.getDomain()+")";

        connector.statementExecution(sqlStatment);
    }

    public Employee getProjectCode(String projectName) throws SQLException {
        sqlStatment = " select project_code from project where project_name="+projectName;
        ResultSet result= connector.dataRetrieve(sqlStatment);
        Employee emp = new Employee();
        //processing the result
        while(result.next()){
            emp.setEmp_code(result.getString("emp_code"));
            emp.setEmail(result.getString("email"));
            emp.setFirstName(result.getString("first_name"));
            emp.setLastName(result.getString("last_name"));
            emp.setPhone_number(result.getInt("phone_number"));
            emp.setJoiningDate(result.getDate("join_date"));
            emp.setEmp_type(result.getString("emp_type"));
            emp.setProject_code(result.getString("project_code"));
            emp.setNo_of_days_present(result.getInt("no_of_days_present"));
        }
        return emp;
    }

    public List<ProjectResult> getListOfProjects() throws SQLException {
        sqlStatment = "SELECT project_code, project_name FROM project";
        ResultSet resultSet = connector.dataRetrieve(sqlStatment);
        ProjectResult projectResult = new ProjectResult();
        List<ProjectResult> result = new ArrayList<ProjectResult>();
        while(resultSet.next()){
            projectResult.setProject_code(resultSet.getString("project_code"));
            projectResult.setProject_name(resultSet.getString("project_name"));
            result.add(projectResult);
        }
        return result;
    }
}
