package com.ex7.restfulapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users",schema = "ex03_mysql", catalog = "")
public class UsersEntity {
    private Long userId;
    @Value("${spring.queries.users-query}")
    private String userName;
    @Value("${spring.queries.roles-query}")
    private String userPassword;
    public UsersEntity() {
    }

    public UsersEntity( String userName, String userPassword,String userRoles) {

        this.userName = userName;
        this.userPassword = userPassword;
        this.userRoles = userRoles;
    }
    @Id
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    @Basic
    @Column(name = "user_role")
    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }

    private String userRoles;


    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(this.userRoles));

        return authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersEntity)) return false;
        UsersEntity that = (UsersEntity) o;
        return getUserId().equals(that.getUserId()) &&
                getUserName().equals(that.getUserName()) &&
                getUserPassword().equals(that.getUserPassword()) &&
                getUserRoles().equals(that.getUserRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUserName(), getUserPassword(), getUserRoles());
    }

    @Override
    public String toString() {
        return "username: "+userName+"\t | Password: "+userPassword+"\t |"+"Role: "+ userRoles;
    }
}
