package org.mikejuliet.mnrega.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Employee {
    private String emp_code;
    private String firstName;
    private String lastName;
    private int phone_number;
    private String email;
    private Date joiningDate;
    private String emp_type;
    private int no_of_days_present;
    private String project_code;
    private String username;
    private String password;
}
