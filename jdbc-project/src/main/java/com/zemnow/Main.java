package com.zemnow;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zemnow.dto.UserDto;
import com.zemnow.entity.User;
import com.zemnow.service.UserService;
import com.zemnow.service.userDtoService;
import com.zemnow.util.DatabaseConfiguration;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        DatabaseConfiguration database = new DatabaseConfiguration();
        Connection connection = database.connectToDb();
        UserService userService = new UserService();

       /* userService.createTable(connection, "user_table");*/

       User marty = new User(13, "Marty", "Maison",
                "maison@gmail.com", "martyisthebest666", "2015-03-31");

        /*userService.insertRow(connection, marty);*/

/*
        List<User> userList = userService.readAll(connection);
        userList.forEach(System.out::println);
*/

/*        System.out.println(userService.readRow(connection, 5));*/

/*
        userService.updateUser(connection, "newpassword", 13);
*/

/*
        userService.deleteUserById(connection, 13);
*/
        userDtoService userDtoService = new userDtoService();
        UserDto olly = new UserDto(19, "Olly", "Olive",
                "olives@gmail.com", "ollyaloha123", "2009-12-25");
        String ollyJson = userDtoService.serializeUser(olly);
        System.out.println(ollyJson);

    }
}
