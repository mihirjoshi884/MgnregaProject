package org.mikejuliet.mnrega.backend.repository.repoimpl;

import org.mikejuliet.mnrega.backend.config.DatabaseConfiguration;
import org.mikejuliet.mnrega.backend.config.DatabaseConnector;
import org.mikejuliet.mnrega.backend.entities.Users;
import org.mikejuliet.mnrega.backend.repository.mgnregaUserRepository;
import org.mikejuliet.mnrega.backend.entities.helpingResult.UserResult;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MgnregaUserRepositoryImpl implements mgnregaUserRepository {

    private final DatabaseConfiguration configuration = new DatabaseConfiguration();
    private final DatabaseConnector connector = new DatabaseConnector();
    String sqlStatment;
//    public void createUser(Users user) throws SQLException {
////        sqlStatment = "INSERT INTO " +
////                "users(user_code,first_name,last_name,tenure,salary,phone_number,email,username,password,user_type)" +
////                "VALUES("+user.getUser_code()+"," +
////                user.getFirst_name()+","+
////                user.getLast_name()+","+
////                user.getTenure()+"," +
////                user.getSalary()+","+
////                user.getPhone()+","+
////                user.getEmail()+","+
////                user.getUsername()+","+
////                user.getPassword()+","+
////                user.getUserType()+")";
//        sqlStatment = "INSERT INTO users(user_code,first_name,last_name,tenure,salary,phone_number,email,username,password,user_type)" +
//                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
//        PreparedStatement sqlStatement = connector.getConnection().prepareStatement(sqlStatment);
//        sqlStatement.setString(1,user.getUser_code());
//        sqlStatement.setString(2,user.getFirst_name());
//        sqlStatement.setString(3,user.getLast_name());
//        sqlStatement.setInt(4,user.getTenure());
//        sqlStatement.setInt(5,user.getSalary());
//        sqlStatement.setInt(6,user.getPhone());
//        sqlStatement.setString(7,user.getEmail());
//        sqlStatement.setString(8,user.getUsername());
//        sqlStatement.setString(9,user.getPassword());
//        sqlStatement.setString(10,user.getUserType());
//
//        connector.statementExecution(sqlStatement);
//    }
public void createUser(Users user) throws SQLException {
    sqlStatment = "INSERT INTO users(user_code, first_name, last_name, tenure, salary, phone_number, email, username, password, user_type) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement sqlStatement = connector.getConnection().prepareStatement(sqlStatment);
    sqlStatement.setString(1, user.getUser_code());
    sqlStatement.setString(2, user.getFirst_name());
    sqlStatement.setString(3, user.getLast_name());
    sqlStatement.setInt(4, user.getTenure());
    sqlStatement.setInt(5, user.getSalary());
    sqlStatement.setInt(6, user.getPhone());
    sqlStatement.setString(7, user.getEmail());
    sqlStatement.setString(8, user.getUsername());
    sqlStatement.setString(9, user.getPassword());
    sqlStatement.setString(10, user.getUserType());

    connector.statementExecution(sqlStatement);
}

    public Users findUserByUsername(String username) throws SQLException {
        Users user = new Users();
        sqlStatment = "SELECT * FROM users WHERE username ="+ username;
        ResultSet resultSet = connector.dataRetrieve(sqlStatment);
        while(resultSet.next()){
            user.setUser_code(resultSet.getString("user_code"));
            user.setFirst_name(resultSet.getString("first_name"));
            user.setLast_name(resultSet.getString("last_name"));
            user.setUserType(resultSet.getString("user_type"));
            user.setEmail(resultSet.getString("email"));
            user.setPhone(resultSet.getInt("phone_number"));
            user.setTenure(resultSet.getInt("tenure"));
            user.setPassword(resultSet.getString("password"));
            user.setSalary(resultSet.getInt("salary"));
        }
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
            response.setUser_type(resultSet.getString("user_type"));
            result.add(response);
        }
        return result;
    }

    public UserResult findGpmUserById(Users user) throws SQLException {
        UserResult response = new UserResult();
        sqlStatment = "SELECT * FROM users WHERE user_code="+user.getUser_code()+"&& user_type= GPM";
        ResultSet resultSet = connector.dataRetrieve(sqlStatment);
        while(resultSet.next()){
            response.setUser_code(resultSet.getString("user_code"));
            response.setName(resultSet.getString("first_name")
                    .concat(resultSet.getString("last_name")));
            response.setEmail(resultSet.getString("email"));
            response.setTenure(resultSet.getInt("tenure"));
            response.setSalary(resultSet.getInt("salary"));
            response.setPhone(resultSet.getInt("phone_number"));
            response.setUser_type(resultSet.getString("user_type"));
        }
        return response;
    }

    public List<UserResult> findAllBDOUsers() throws SQLException {
        UserResult response = new UserResult();
        sqlStatment = "SELECT * FROM users WHERE user_type = BDO";
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
            response.setUser_type(resultSet.getString("user_type"));
            result.add(response);
        }
        return result;
    }

    public UserResult findBDOUserById(Users user) throws SQLException {
        UserResult response = new UserResult();
        sqlStatment = "SELECT * FROM users WHERE user_code="+user.getUser_code()+"&& user_type= BDO";
        ResultSet resultSet = connector.dataRetrieve(sqlStatment);
        while(resultSet.next()){
            response.setUser_code(resultSet.getString("user_code"));
            response.setName(resultSet.getString("first_name")
                    .concat(resultSet.getString("last_name")));
            response.setEmail(resultSet.getString("email"));
            response.setTenure(resultSet.getInt("tenure"));
            response.setSalary(resultSet.getInt("salary"));
            response.setPhone(resultSet.getInt("phone_number"));
            response.setUser_type(resultSet.getString("user_type"));
        }
        return response;
    }


}
