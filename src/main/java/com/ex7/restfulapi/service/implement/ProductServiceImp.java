package com.ex7.restfulapi.service.implement;

import com.ex7.restfulapi.model.ProductEntity;
import com.ex7.restfulapi.model.WareHourseEntity;
import com.ex7.restfulapi.rowMapped.productMapped;
import com.ex7.restfulapi.service.serviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductServiceImp  implements serviceRepository<ProductEntity> {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }
    @Override
    public List<ProductEntity> getAll() {
        String sql = "Select * from product";
        List<ProductEntity> list = jdbcTemplate.query(sql,new productMapped());
//        list.forEach(productEntity -> System.out.println(productEntity.isStatus()));
        return list;
    }

    @Override
    public ProductEntity getById(Long id) {
        String sql = "Select * from product where `product_id` = ? ";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new productMapped());
    }

    @Override
    public ProductEntity create(ProductEntity prop) {
        String product_code = identity();
        String sql = "INSERT INTO `product` (`product_code`, `category_id`, `warehouse_id`, " +
                "`product_name`, `product_description`, `product_image`, `product_price`, `product_quanlity`," +
                " `product_selled`, `create_on`, `update_on`,`status`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                " ?, ?,?)";
        jdbcTemplate.update(sql,new Object[]{product_code,prop.getCategoryId(),prop.getWarehouseId(),
        prop.getProductName(),prop.getProductDescription(),prop.getProductImage(),prop.getProductPrice(),prop.getProductQuanlity(),
        prop.getProductSelled(),prop.getCreateOn(),prop.getUpdateOn(),Boolean.TRUE});
        return prop;
    }

    @Override
    public ProductEntity update(ProductEntity prop, Long id) {
        String sql = "UPDATE `product` SET `product_code` = ?, `category_id` = ?, `warehouse_id`= ?, " +
                "`product_name`= ?, `product_description`= ?, `product_image`= ?, `product_price`= ?, `product_quanlity`= ?," +
                " `product_selled`= ?, `create_on`= ?, `update_on`= ? WHERE `product_id` = ?";
                jdbcTemplate.update(sql,new Object[]{prop.getProductCode(),prop.getCategoryId(),prop.getWarehouseId(),
                prop.getProductName(),prop.getProductDescription(),prop.getProductImage(),prop.getProductPrice(),prop.getProductQuanlity(),
                prop.getProductSelled(),prop.getCreateOn(),prop.getUpdateOn(),id});
        return prop;
    }

    @Override
    public String delete(Long id) {
      String sql = "UPDATE  product SET status = b'0' where product_id= ? ";
        int isSuccess=  jdbcTemplate.update(sql,id);
        if(isSuccess > 0){
            return "Delete Succesfully";
        }
        return "Delete Failed";
    }

    @Override
    public String identity() {
        List<ProductEntity> list = getAll();
        int max = 0;

        for (int i = 0; i < list.size(); i++) {
            int number = Integer.parseInt(list.get(i).getProductCode().substring(2,list.get(i).getProductCode().length()));
            if(max < number){
                max = number;
            }
        }
        max= max +1;    
        return "SP0"+max;
    }

    public List<ProductEntity> searchProduct(String nameproduct){
        String sql = "Select * from product where product_name like '%' ? '%'";
        List<ProductEntity> list = jdbcTemplate.query(sql,new productMapped(),new Object[]{nameproduct});
        return list;
    }

}
