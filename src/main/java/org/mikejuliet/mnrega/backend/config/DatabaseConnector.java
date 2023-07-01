package org.mikejuliet.mnrega.backend.config;

import java.sql.*;

public class DatabaseConnector {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;
    private DatabaseConfiguration configuration;

    public void DatabaseConnector() throws SQLException {
        connection = DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(),
                configuration.getPassword());
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(),
                configuration.getPassword());
    }
    public ResultSet dataRetrieve(String sqlStatement)  {
        try{
            connection = getConnection();
            statement = connection.prepareStatement(sqlStatement);
            statement.execute();
            resultSet = statement.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            //close resources
            try{
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }

            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return resultSet;
    }
    public void statementExecution(String sqlStatement) {


        try {
            connection = getConnection();
//            PreparedStatement  statement1= connection.prepareStatement(sqlStatement);
//            statement1.execute();

            Statement st = connection.createStatement();
            st.execute(sqlStatement);

            System.out.println("Statement executed successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        } finally {
//            // Close resources
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (statement != null) {
//                    statement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

    }
}
