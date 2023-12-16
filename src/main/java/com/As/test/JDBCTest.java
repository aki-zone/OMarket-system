package com.As.test;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws Exception{
        String sql = "select * from user";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wtumarket?characterEncoding=utf-8",
                "root","12aaaaaa");
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String OId = rs.getString("OId");
                String name = rs.getString("username");
                String password = rs.getString("password");
                String phoneNum = rs.getString("phoneNum");
                String email = rs.getString("email");
                String address = rs.getString("address");
                double balances = rs.getDouble("balances");
                String regsTime = rs.getString("regsTime");

                System.out.println(OId+" "+name+" "+password+" "+phoneNum+" "+email+" "+address+" "+balances+" "+regsTime);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
