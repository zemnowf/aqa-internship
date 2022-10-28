package com.zemnow.util;

import com.zemnow.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConfiguration {
    public Connection connectToDb(){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user_database",
                    "postgres", "Vivvt565");
            if(connection!=null){
                System.out.println("Connection established");
            } else {
                System.out.println("Connection failed");
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }
}
