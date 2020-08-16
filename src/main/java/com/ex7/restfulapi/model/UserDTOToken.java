package com.ex7.restfulapi.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class UserDTOToken {

    private String userName;
    private String userPassword;
    private String userRole;
    private String token;

    public UserDTOToken() {
            this.userName = "Invalid Username";
            this.userPassword = "Invalid Password";
            this.userRole = "Not Have Permission";
            this.token = "Not Found";
    }



    public UserDTOToken(  String userName, String userPassword, String userRole, String token) {

        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.token = token;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTOToken)) return false;
        UserDTOToken that = (UserDTOToken) o;
        return  getUserName().equals(that.getUserName()) &&
                getUserPassword().equals(that.getUserPassword()) &&
                getUserRole().equals(that.getUserRole()) &&
                getToken().equals(that.getToken());
    }

    @Override
    public int hashCode() {
        return Objects.hash(  getUserName(), getUserPassword(), getUserRole(), getToken());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
