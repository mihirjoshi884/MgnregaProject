package org.mikejuliet.mnrega.backend.entities.helpingResult;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class UserProjectResult {
    private int id;
    private String user_code;
    private String project_code;
    private String user_name;
    private String proj_name;
}
