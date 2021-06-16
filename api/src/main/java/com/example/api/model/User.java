package com.example.api.model;

import lombok.Data;

@Data
public class User {

    private long id;
    private String FirstName;
    private String LastName;
    private String Username;
    private String Password;
    private String Email;

    public User() {
    }

    public User(long id, String FirstName, String LastName, String Username, String Password, String Email) {
        super();
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void add(User user) {
    }
}
