package org.mikejuliet.mnrega.backend.repository;

import org.mikejuliet.mnrega.backend.entities.Users;
import org.mikejuliet.mnrega.backend.entities.helpingResult.UserResult;

import java.sql.SQLException;
import java.util.List;

public interface mgnregaUserRepository {
    public void createUser(Users user);
    public Users findUserByUsername(String user) throws SQLException;
    public List<UserResult> findAllGpmUsers() throws SQLException;
    public UserResult findGpmUserById(Users user) throws SQLException;
    public List<UserResult> findAllBDOUsers() throws SQLException;
    public UserResult findBDOUserById(Users user) throws SQLException;
}
