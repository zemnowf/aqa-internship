package com.zemnow.service;

import com.zemnow.entity.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public void createTable(Connection connection, String table_name){
        Statement statement;
        try {
            String query = ("create table " + table_name + "(id serial constraint user_table_pk primary key, " +
                    "first_name varchar(40), " +
                    "last_name varchar(40), " +
                    "email      varchar(40), " +
                    "password   varchar(40), " +
                    "birthday date); \n" +
                    "alter table user_table " +
                    "owner to postgres; \n" +
                    " create unique index user_table_id_uindex " +
                    "on user_table (id) \n; " +
                    "create unique index user_table_email_uindex \n" +
                    "on user_table (email);");
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void insertRow(Connection connection, User user){
        Statement statement;
        try {
            String query = String.format("insert into user_table (id, first_name, last_name, email, password, birthday) " +
                            "values ('%s', '%s', '%s', '%s', '%s', '%s');", user.getId(), user.getFirstName(), user.getLastName(),
                    user.getEmail(), user.getPassword(), Date.valueOf(user.getDate()));

            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public User readRow(Connection connection, Integer id){
        Statement statement;
        ResultSet result = null;
        User user = new User();
        try {
            String query= String.format("select * from user_table where id = %s", id);
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
                user.setId(Integer.parseInt(result.getString("id")));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setDate(result.getString("birthday"));
            }
            System.out.println("read user with id " + result.getString("id") + ": ");
        } catch (Exception e){
            System.out.println(e);
        }
        return user;
    }

    public List<User> readAll(Connection connection){
        Statement statement;
        ResultSet result = null;
        List<User> userList = new ArrayList<>();
        try {
            String query= "select * from user_table";
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                userList.add(new User(Integer.parseInt(result.getString("id")),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("birthday")));
            }
            System.out.println("get all users");
        } catch (Exception e){
            System.out.println(e);
        }
        return userList;
    }

    public void updateUser(Connection connection, String newPassword, Integer id){
        Statement statement;
        try {
            String query = String.format("update user_table set password='%s' where id = '%s'", newPassword, id);
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("user with id " + id + " password was changed with " + newPassword);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteUserById(Connection connection, Integer id) {
        Statement statement;
        try {
            String query = String.format("delete from user_table where id = '%s'", id);

            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("User with id " + id + " was deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
