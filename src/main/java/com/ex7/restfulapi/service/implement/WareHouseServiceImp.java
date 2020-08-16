package com.ex7.restfulapi.service.implement;

import com.ex7.restfulapi.model.WareHourseEntity;
import com.ex7.restfulapi.rowMapped.wareHouseMapped;
import com.ex7.restfulapi.service.serviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Service
public class WareHouseServiceImp implements serviceRepository<WareHourseEntity> {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    @Override
    public List<WareHourseEntity> getAll() {
        String sql = "Select * from ware_hourse";
        return jdbcTemplate.query(sql,new wareHouseMapped());
    }

    @Override
    public WareHourseEntity getById(Long id) {
        String sql = "Select * from ware_hourse where ware_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},new wareHouseMapped());
    }

    @Override
    public WareHourseEntity create(WareHourseEntity wareHourseEntity) {
        String ware_code = identity();
        String sql = "INSERT INTO `ware_hourse` (`ware_code`, `ware_address`, `create_on`, `update_on`) " +
                "VALUES ( ?, ?, ?, ?)";
        jdbcTemplate.update(sql,new Object[]{ware_code,wareHourseEntity.getWareAddress(),wareHourseEntity.getCreateOn(),wareHourseEntity.getUpdateOn()});
    return wareHourseEntity;
    }

    @Override
    public WareHourseEntity update(WareHourseEntity wareHourseEntity, Long id) {
        String sql = "UPDATE  `ware_hourse` SET `ware_code` = ?, `ware_address` = ?, `create_on` = ?, `update_on` = ? WHERE  ware_id = ?";
        jdbcTemplate.update(sql,new Object[]{wareHourseEntity.getWareCode(),wareHourseEntity.getWareAddress(),wareHourseEntity.getCreateOn(),wareHourseEntity.getUpdateOn(),wareHourseEntity.getWareId()});
        return wareHourseEntity;
    }

    @Override
    public String delete(Long id) {
        String sql = "UPDATE `ware_hourse` SET status = b'0' WHERE  ware_id = ? ";
        int isSuccess=  jdbcTemplate.update(sql,id);
        if(isSuccess > 0){
            return "Delete Succesfully";
        }
        return "Delete Failed";
    }

    @Override
    public String identity() {
        List<WareHourseEntity> list = getAll();
        int max = 0;

        for (int i = 0; i < list.size(); i++) {
            int number = Integer.parseInt(list.get(i).getWareCode().substring(3,list.get(i).getWareCode().length()));
            if(max < number){
                max = number;
            }
        }
        max= max +1;
        return "KHO0"+max;
    }
}
