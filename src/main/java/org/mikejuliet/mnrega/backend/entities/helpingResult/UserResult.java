package org.mikejuliet.mnrega.backend.entities.helpingResult;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class UserResult {
    private String user_code;
    private String name;
    private int tenure;
    private int salary;
    private int phone;
    private String email;
}
