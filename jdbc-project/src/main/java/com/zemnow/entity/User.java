package com.zemnow.entity;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String date;

    public User(Integer id, String firstName, String lastName, String email, String password, String date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.date = date;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User " +
                "id: " + id +
                "\nfirstName: " + firstName + '\n' +
                "lastName: " + lastName + '\n' +
                "email: " + email + '\n' +
                "password: " + password + '\n' +
                "date: " + date + '\n';
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
