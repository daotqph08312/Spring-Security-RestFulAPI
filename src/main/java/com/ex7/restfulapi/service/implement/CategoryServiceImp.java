package com.ex7.restfulapi.service.implement;

import com.ex7.restfulapi.model.CategoryEntity;
import com.ex7.restfulapi.model.WareHourseEntity;
import com.ex7.restfulapi.rowMapped.categoryMapped;
import com.ex7.restfulapi.service.serviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryServiceImp implements serviceRepository<CategoryEntity> {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired private PlatformTransactionManager platformTransactionManager;

    public void setTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }
    @Override
    public List<CategoryEntity> getAll() {

        String sql = "Select * from Category";
        List<CategoryEntity> list = new ArrayList<>();
        try{
            list = jdbcTemplate.query(sql,new categoryMapped());
        }catch (Exception e){
        }

       return list;
    }

    @Override
    public CategoryEntity getById(Long id){
        String sql = "Select * from Category where category_id = ?";
        CategoryEntity categoryEntity;
        try{
            categoryEntity = jdbcTemplate.queryForObject(sql,new Object[]{id},new categoryMapped());
            return categoryEntity;
        }catch (Exception e){
        }
        return null;
    }

    @Override
    public CategoryEntity create(CategoryEntity categoryEntity) {
        String categoryCode = identity();
        String sql = "INSERT INTO `category` ( `category_code`, `category_name`, `category_description`, `create_on`, `update_on`) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{categoryCode,categoryEntity.getCategoryName(),categoryEntity.getCategoryDescription(),categoryEntity.getCreateOn(),categoryEntity.getUpdateOn()});
        return categoryEntity;
    }

    @Override
    public CategoryEntity update(CategoryEntity categoryEntity, Long id) {
        String sql = "UPDATE `category` SET  `category_code` = ?, `category_name` = ?, `category_description` = ?, `create_on` = ?, `update_on` = ? WHERE `category_id` = ?";
        jdbcTemplate.update(sql,new Object[]{categoryEntity.getCategoryCode(),categoryEntity.getCategoryName(),categoryEntity.getCategoryDescription(),categoryEntity.getCreateOn(),categoryEntity.getUpdateOn(),id});
        return categoryEntity;
    }

    @Override
    public String delete(Long id) {
        String message = null;
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            deleteProductOfCategory(id);
            String sql = "Delete from category where category_id = ?";
            int isSuccess = jdbcTemplate.update(sql,id);
            if(isSuccess > 0){
                message= "Delete Succesfully";
            }else{
                message = "Delete Failed";
            }
            platformTransactionManager.commit(transactionStatus);
        }catch (Exception e){
        platformTransactionManager.rollback(transactionStatus);
        }

       return message;
    }

    @Override
    public String identity() {
        List<CategoryEntity> list = getAll();
        int max = 0;

        for (int i = 0; i < list.size(); i++) {
            int number = Integer.parseInt(list.get(i).getCategoryCode().substring(2,list.get(i).getCategoryCode().length()));
            if(max < number){
                max = number;

            }
        }
        max= max +1;
        return "DM0"+max;
    }

    public void deleteProductOfCategory(Long category_id){
        String sql = "Delete from product where category_id = ?";
        jdbcTemplate.update(sql,category_id);
    }

}
