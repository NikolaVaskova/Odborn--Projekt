package org.example;

public class User {
    private int id;
    private String userName;
    private String password;

    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(){
        this.userName = userName;
    }
}