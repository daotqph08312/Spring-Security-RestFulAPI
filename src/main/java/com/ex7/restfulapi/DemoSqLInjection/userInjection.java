package com.ex7.restfulapi.DemoSqLInjection;

import com.ex7.restfulapi.model.UsersEntity;
import com.ex7.restfulapi.rowMapped.usersMapped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class userInjection {
    @Autowired private
    JdbcTemplate jdbcTemplate;
    public boolean Login(String username , String password){
        String sql = "Select * from users where user_name ='"+username+"' and user_password = '"+password+"'";
        try {
            UsersEntity usersEntity = jdbcTemplate.queryForObject(sql,new usersMapped());
            System.out.println(usersEntity.toString());
            if(usersEntity != null){
                return true;
            }
        }catch (Exception e){
        }
        return false;
    }
}
