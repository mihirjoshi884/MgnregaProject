package org.mikejuliet.mnrega.backend.repository.repoimpl;

import org.mikejuliet.mnrega.backend.config.DatabaseConfiguration;
import org.mikejuliet.mnrega.backend.config.DatabaseConnector;
import org.mikejuliet.mnrega.backend.entities.Employee;
import org.mikejuliet.mnrega.backend.entities.helpingResult.EmployeeResult;
import org.mikejuliet.mnrega.backend.repository.mgnregaEmployeeRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MgnregaEmployeeRepositoryImpl implements mgnregaEmployeeRepository {
    private String sqlStatment;
    public final DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
    public final DatabaseConnector connector = new DatabaseConnector();
    public void createEmployee(Employee employee) {
        sqlStatment = new StringBuilder()
                .append("INSERT INTO employee(emp_code,first_name,last_name,phone_number,")
                .append("email,emp_type,join_date,username,password)VALUES(")
                .append(employee.getEmp_code()).append(",")
                .append(employee.getFirstName()).append(",")
                .append(employee.getLastName()).append(",")
                .append(employee.getPhone_number()).append(",")
                .append(employee.getEmail()).append(",")
                .append(employee.getEmp_type()).append(",")
                .append(employee.getJoiningDate()).append(",")
                .append(employee.getUsername()).append(",")
                .append(employee.getPassword()).append(")").toString();

        connector.statementExecution(sqlStatment);
    }

    public EmployeeResult showEmployeeDetails(Employee employee) {
        EmployeeResult result = null;
        result.setEmp_code(employee.getEmp_code());
        result.setFirstName(employee.getFirstName());
        result.setLastName(employee.getLastName());
        result.setPhone_number(employee.getPhone_number());
        result.setEmail(employee.getEmail());
        result.setEmp_type(employee.getEmp_type());
        result.setJoiningDate(employee.getJoiningDate());
        result.setProject_code(employee.getProject_code());
        result.setNo_of_days_present(employee.getNo_of_days_present());
        return result;
    }

    public Employee findEmployeeByUsername(String employee_username) throws SQLException {
        Employee employee = null;
        sqlStatment = new StringBuilder()
                .append("SELECT * FROM employee WHERE username = ")
                .append(employee_username).toString();
        ResultSet result = connector.dataRetrieve(sqlStatment);
        while(result.next()){
            employee.setEmp_code(result.getString("emp_code"));
            employee.setFirstName(result.getString("first_name"));
            employee.setLastName(result.getString("last_name"));
            employee.setPhone_number(result.getInt("phone_number"));
            employee.setEmail(result.getString("email"));
            employee.setEmp_type(result.getString("emp_type"));
            employee.setJoiningDate(result.getDate("join_date"));
            employee.setUsername(result.getString("username"));
            employee.setPassword(result.getString("password"));
            employee.setProject_code(result.getString("project_code"));
        }
        return employee;
    }
}
