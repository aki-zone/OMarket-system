package com.As.dbc;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static final String JDBCPROPERTY = "jdbc.properties";
    private static String DBDRIVER= "";
    private static String DBURL= "";
    private static String DBUSER= "";
    private static String PASSWORD= "";

    private Connection connection;

    static {
        try{
            Properties property = new Properties();
            InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream(JDBCPROPERTY);

            property.load(new InputStreamReader(inputStream,"utf-8"));
            inputStream.close();
            DBDRIVER = property.getProperty("jdbc.driver");
            DBURL = property.getProperty("jdbc.connection.url");
            DBUSER= property.getProperty("jdbc.connection.username");
            PASSWORD = property.getProperty("jdbc.connection.password");
            Class.forName(DBDRIVER);

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public DatabaseConnection(){
        try{
            this.connection = DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

    public void close(){
        if(this.connection != null){
            try{
                this.connection.close();
            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }
    }
}
