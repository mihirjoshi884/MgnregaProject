package org.mikejuliet.mnrega.backend.entities.helpingResult;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class UserResult {
    private String user_code;
    private String name;
    private int tenure;
    private int salary;
    private int phone;
    private String email;
    private String user_type;
}
