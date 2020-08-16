package com.ex7.restfulapi.rowMapped;

import com.ex7.restfulapi.model.UsersEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class usersMapped implements RowMapper<UsersEntity> {
    @Override
    public UsersEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUserId(rs.getLong("user_id"));
        usersEntity.setUserName(rs.getString("user_name"));
        usersEntity.setUserPassword(rs.getString("user_password"));
        usersEntity.setUserRoles(rs.getString("user_role"));
        return usersEntity;
    }
}
