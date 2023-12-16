package com.As.test;

import com.As.dbc.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from user";

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                String OId = resultSet.getString("OId");
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phoneNum = resultSet.getString("phoneNum");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                double balances = resultSet.getDouble("balances");
                String regsTime = resultSet.getString("regsTime");

                System.out.println(OId+" "+name+" "+password+" "+phoneNum+" "+email+" "+address+" "+balances+" "+regsTime);
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
