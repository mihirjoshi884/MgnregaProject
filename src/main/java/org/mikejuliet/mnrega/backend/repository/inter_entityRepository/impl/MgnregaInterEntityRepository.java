package org.mikejuliet.mnrega.backend.repository.inter_entityRepository.impl;

import org.mikejuliet.mnrega.backend.config.DatabaseConfiguration;
import org.mikejuliet.mnrega.backend.config.DatabaseConnector;
import org.mikejuliet.mnrega.backend.entities.Project;
import org.mikejuliet.mnrega.backend.entities.Users;
import org.mikejuliet.mnrega.backend.entities.helpingResult.UserProjectResult;
import org.mikejuliet.mnrega.backend.repository.inter_entityRepository.mgnregaInterEntityRepository;
import org.mikejuliet.mnrega.backend.services.impl.HelpingServicesImpl;

public class MgnregaInterEntityRepository implements mgnregaInterEntityRepository {
    private HelpingServicesImpl helpingServices;
    private final DatabaseConnector connector = new DatabaseConnector();
    private final DatabaseConfiguration configuration = new DatabaseConfiguration();
    private static String sqlstatement;
    public void projectAllocationForGpm(UserProjectResult userProjectResult) {
        sqlstatement = new StringBuilder()
                .append("INSERT INTO project_allocation(id,user_code,user_name,project_code,project_name)")
                .append("VALUES(")
                .append(userProjectResult.getId())
                .append(userProjectResult.getUser_code())
                .append(userProjectResult.getUser_name())
                .append(userProjectResult.getProject_code())
                .append(userProjectResult.getProj_name()).append(")").toString();
        connector.statementExecution(sqlstatement);

    }


    public UserProjectResult setFeilds(Users user, Project project) {
        UserProjectResult response = null;
        response.setId(helpingServices.idForProject_allocation());
        response.setUser_code(user.getUser_code());
        response.setUser_name(user.getFirst_name().concat(user.getLast_name()));
        response.setProject_code(project.getProject_code());
        response.setProject_code(project.getProject_name());

        return response;
    }

}
