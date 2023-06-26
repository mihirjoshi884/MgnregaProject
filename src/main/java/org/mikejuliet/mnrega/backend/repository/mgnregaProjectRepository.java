package org.mikejuliet.mnrega.backend.repository;

import org.mikejuliet.mnrega.backend.entities.Employee;
import org.mikejuliet.mnrega.backend.entities.Project;
import org.mikejuliet.mnrega.backend.entities.helpingResult.ProjectResult;

import java.sql.SQLException;
import java.util.List;

public interface mgnregaProjectRepository {
    public void createProject(Project project);
    public Employee getProjectCode(String projectName) throws SQLException;
    public List<ProjectResult> getListOfProjects() throws SQLException;
}
