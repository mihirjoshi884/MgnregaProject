package org.mikejuliet.mnrega.backend.services;

public interface helpingServices {
    public String BDOuser_code(int id);
    public String GPMuser_code(int id);
    public String project_code(Integer id,String projectName);
    public String employeeCode(String empl_code,String project);
    public String employeeCode(int id);
    public int idForProject_allocation();
    public String passwordProtection(String password);
}
