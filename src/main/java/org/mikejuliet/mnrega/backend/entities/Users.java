package org.mikejuliet.mnrega.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Users {
    private String user_code;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private int tenure;
    private int salary;
    private int phone;
    private String email;
    private int id;
    private String userType;
}
