package com.ex7.restfulapi.service.implement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ex7.restfulapi.rowMapped.categoryMapped;
import com.ex7.restfulapi.rowMapped.productMapped;
import com.ex7.restfulapi.rowMapped.usersMapped;
import com.ex7.restfulapi.service.serviceRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ex7.restfulapi.model.UsersEntity;
@Repository
public class UsersService   {
   @Autowired private
    JdbcTemplate jdbcTemplate;

  
    public List<UsersEntity> getAll() {
       String sql = "Select * from users";
        return jdbcTemplate.query(sql,new usersMapped());
    }

  
    public UsersEntity getById(String username)  {
        String sql = "Select * from users where user_name = ?";
        UsersEntity usersEntity = null;
        try {
             usersEntity = jdbcTemplate.queryForObject(sql,new Object[]{username},new usersMapped());
                return usersEntity;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

  
    public UsersEntity create(UsersEntity usersEntity) {
    String sql  = "INSERT INTO `users` (`user_name`, `user_password`, `user_role`) VALUES (?,?,?)";
    jdbcTemplate.update(sql,new Object[]{usersEntity.getUserName(),usersEntity.getUserPassword(),usersEntity.getUserRoles()});
    return usersEntity;
    }

  
    public UsersEntity update(UsersEntity usersEntity, String username) {
        String sql  = "UPDATE `users` SET `user_password` = ?, `user_role` = ? WHERE user_name = ?";
        jdbcTemplate.update(sql,new Object[]{usersEntity.getUserPassword(),usersEntity.getUserRoles(),username});
        return usersEntity;
    }

  
    public String delete(Long id) {
        return null;
    }

  
    public String identity() {
        return null;
    }
    public boolean Login(UsersEntity usersEntity){
        String sql = "SELECT * FROM `users` where user_name = ? and user_password = ?";
        String username = usersEntity.getUserName();
        String password = usersEntity.getUserPassword();
        UsersEntity users = jdbcTemplate.queryForObject(sql,new Object[]{username,password},new usersMapped());
        if(users != null){
            return true;
        }
        return false;
    }
}