package org.mikejuliet.mnrega.backend.repository.repoimpl;

import org.mikejuliet.mnrega.backend.config.DatabaseConfiguration;
import org.mikejuliet.mnrega.backend.config.DatabaseConnector;
import org.mikejuliet.mnrega.backend.entities.Users;
import org.mikejuliet.mnrega.backend.repository.mgnregaUserRepository;
import org.mikejuliet.mnrega.backend.entities.helpingResult.UserResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MgnregaUserRepositoryImpl implements mgnregaUserRepository {

    private final DatabaseConfiguration configuration = new DatabaseConfiguration();
    private final DatabaseConnector connector = new DatabaseConnector();
    String sqlStatment;
    public void createUser(Users user) {
        sqlStatment = "INSERT INTO " +
                "users(user_code,first_name,last_name,user_type,tenure,salary,phone_number,email,username,password)" +
                "VALUES("+user.getUser_code()+"," +
                user.getFirst_name()+","+
                user.getLast_name()+","+
                user.getTenure()+"," +
                user.getSalary()+","+
                user.getPhone()+","+
                user.getEmail()+","+
                user.getUsername()+","+
                user.getPassword()+","+
                user.getUserType()+")";

        connector.statementExecution(sqlStatment);
    }

    public Users findUserByUsername(Users user) {
        sqlStatment = "SELECT * FROM users WHERE username ="+ user.getUsername();
        connector.dataRetrieve(sqlStatment);
        return user;
    }

    public List<UserResult> findAllGpmUsers() throws SQLException {
        UserResult response = new UserResult();
        sqlStatment = "SELECT * FROM users WHERE user_type = GPM";
        ResultSet resultSet = connector.dataRetrieve(sqlStatment);
        List<UserResult> result = new ArrayList<UserResult>();
        while(resultSet.next()){
            response.setUser_code(resultSet.getString("user_code"));
            response.setName(resultSet.getString("first_name")
                    .concat(resultSet.getString("last_name")));
            response.setEmail(resultSet.getString("email"));
            response.setTenure(resultSet.getInt("tenure"));
            response.setSalary(resultSet.getInt("salary"));
            response.setPhone(resultSet.getInt("phone_number"));
            result.add(response);
        }
        return result;
    }

    public UserResult findGpmUserById(Users user) throws SQLException {
        UserResult response = new UserResult();
        sqlStatment = "SELECT * FROM users WHERE user_code="+user.getUser_code();
        ResultSet resultSet = connector.dataRetrieve(sqlStatment);
        while(resultSet.next()){
            response.setUser_code(resultSet.getString("user_code"));
            response.setName(resultSet.getString("first_name")
                    .concat(resultSet.getString("last_name")));
            response.setEmail(resultSet.getString("email"));
            response.setTenure(resultSet.getInt("tenure"));
            response.setSalary(resultSet.getInt("salary"));
            response.setPhone(resultSet.getInt("phone_number"));
        }
        return response;
    }


}
