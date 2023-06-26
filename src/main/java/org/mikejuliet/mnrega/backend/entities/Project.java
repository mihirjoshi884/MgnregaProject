package org.mikejuliet.mnrega.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter  @AllArgsConstructor
public class Project {
    private String project_code;
    private String project_name;
    private String nameOfGPM;
    private int vacancy;
    private String Region;
    private String state;
    private String domain;
}
