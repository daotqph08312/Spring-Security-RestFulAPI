package com.ex7.restfulapi.rowMapped;

import com.ex7.restfulapi.model.ProductEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class productMapped implements RowMapper<ProductEntity> {

    @Override
    public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(rs.getLong("product_id"));
        productEntity.setProductCode(rs.getString("product_code"));
        productEntity.setCategoryId(rs.getLong("category_id"));
        productEntity.setWarehouseId(rs.getLong("warehouse_id"));
        productEntity.setProductName(rs.getString("product_name"));
        productEntity.setProductDescription(rs.getString("product_description"));
        productEntity.setProductImage(rs.getString("product_image"));
        productEntity.setProductImage(rs.getString("product_image"));
        productEntity.setProductPrice(rs.getBigDecimal("product_price"));
        productEntity.setProductQuanlity(rs.getInt("product_quanlity"));
        productEntity.setProductSelled(rs.getInt("product_selled"));
        productEntity.setCreateOn(rs.getTimestamp("create_on"));
        productEntity.setUpdateOn(rs.getTimestamp("update_on"));
        productEntity.setStatus(rs.getBoolean("status"));
        return productEntity;
    }
}
