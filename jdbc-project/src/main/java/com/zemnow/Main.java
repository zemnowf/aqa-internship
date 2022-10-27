package com.zemnow;

import com.zemnow.entity.User;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DatabaseConfiguration database = new DatabaseConfiguration();
        Connection connection = database.connectToDb();

        //database.createTable(connection, "user_table");

        User marty = new User(13, "Marty", "Maison",
                "maison@gmail.com", "martyisthebest666", "2015-03-31");

        //database.insertRow(connection, marty);

        //List<User> userList = database.readAll(connection);
        //userList.forEach(System.out::println);

        //System.out.println(database.readRow(connection, 5));

        database.updateUser(connection, "newpassword", 13);

    }
}
