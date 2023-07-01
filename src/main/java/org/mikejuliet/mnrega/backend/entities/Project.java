package org.mikejuliet.mnrega.backend.entities;

import lombok.*;

@NoArgsConstructor @Getter @Setter  @AllArgsConstructor @ToString
public class Project {
    private String project_code;
    private String project_name;
    private String nameOfGPM;
    private int vacancy;
    private String Region;
    private String state;
    private String domain;
}
