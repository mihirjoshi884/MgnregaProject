package org.mikejuliet.mnrega.backend.config;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Setter @Getter
public class DatabaseConfiguration {
    private String database = "MGNERGA";
    private String username;
    private String password;
    private String url;

    public  DatabaseConfiguration getConnection(){
        String url = "jdbc:mysql://localhost:3306/"+database;
        String username = "root";
        String password = "Mimioscar030203";
        return new DatabaseConfiguration(url,database,username,password);
    }



}