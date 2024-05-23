package org.example.logic;

import org.sqlite.core.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
    private int id;
    private String Name;
    private String email;
    private String password;

    public User(int id, String Name, String email, String password) {
        this.id = id;
        this.Name = Name;
        this.email = email;
        this.password = password;
    }
    public String getUserName() {
        return Name;
    }
    public void setUserName(){
        this.Name = Name;
    }
}