package com.example.web;


import javax.validation.constraints.Size;

public class LoginInfo {

    @Size(min=3, max=6, message = "username length should be 3 ~ 6")
    private String userName;

    @Size(min=6, max=6, message = "password length should be 6")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
