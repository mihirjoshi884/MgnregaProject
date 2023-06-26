package org.mikejuliet.mnrega.backend.repository;

import org.mikejuliet.mnrega.backend.entities.Employee;
import org.mikejuliet.mnrega.backend.entities.helpingResult.EmployeeResult;

import java.sql.SQLException;

public interface mgnregaEmployeeRepository {
    public void createEmployee(Employee employee);
    public EmployeeResult showEmployeeDetails(Employee employee);
    public Employee findEmployeeByUsername(String employee_username) throws SQLException;
}
