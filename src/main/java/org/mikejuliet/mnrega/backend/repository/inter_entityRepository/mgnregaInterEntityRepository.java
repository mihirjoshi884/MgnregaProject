package org.mikejuliet.mnrega.backend.repository.inter_entityRepository;

import org.mikejuliet.mnrega.backend.entities.Project;
import org.mikejuliet.mnrega.backend.entities.Users;
import org.mikejuliet.mnrega.backend.entities.helpingResult.UserProjectResult;

public interface mgnregaInterEntityRepository {
    public void projectAllocationForGpm(UserProjectResult userProjectResult);
    public UserProjectResult setFeilds(Users user, Project project);
}
