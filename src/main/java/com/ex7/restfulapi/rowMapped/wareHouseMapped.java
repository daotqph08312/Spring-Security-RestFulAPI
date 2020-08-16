package com.ex7.restfulapi.rowMapped;

import com.ex7.restfulapi.model.WareHourseEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class wareHouseMapped implements RowMapper<WareHourseEntity> {
    @Override
    public WareHourseEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        WareHourseEntity wareHourseEntity = new WareHourseEntity();
        wareHourseEntity.setWareId(rs.getLong("ware_id"));
        wareHourseEntity.setWareCode(rs.getString("ware_code"));
        wareHourseEntity.setWareAddress(rs.getString("ware_address"));
        wareHourseEntity.setCreateOn(rs.getTimestamp("create_on"));
        wareHourseEntity.setUpdateOn(rs.getTimestamp("update_on"));
        wareHourseEntity.setStatus(rs.getBoolean("status"));
        return wareHourseEntity;
    }
}
