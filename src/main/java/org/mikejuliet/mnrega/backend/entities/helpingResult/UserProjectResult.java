package org.mikejuliet.mnrega.backend.entities.helpingResult;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class UserProjectResult {
    private int id;
    private String user_code;
    private String project_code;
    private String user_name;
    private String proj_name;
}
