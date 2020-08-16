package com.ex7.restfulapi.rowMapped;

import com.ex7.restfulapi.model.CategoryEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class categoryMapped implements RowMapper<CategoryEntity> {
    @Override
    public CategoryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(rs.getLong("category_id"));
        categoryEntity.setCategoryCode(rs.getString("category_code"));
        categoryEntity.setCategoryName(rs.getString("category_name"));
        categoryEntity.setCategoryDescription(rs.getString("category_description"));
        categoryEntity.setCreateOn(rs.getTimestamp("create_on"));
        categoryEntity.setUpdateOn(rs.getTimestamp("update_on"));
        categoryEntity.setStatus(rs.getBoolean("status"));
        return categoryEntity;
    }
}
