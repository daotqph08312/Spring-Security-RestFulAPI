package com.ex7.restfulapi.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "ex03_mysql", catalog = "")
public class ProductEntity {
    private long productId;
    private String productCode;
    @NotNull
    private long categoryId;
    @NotNull
    private long warehouseId;
    @NotBlank
    private String productName;
    private String productDescription;
    @NotNull
    private String productImage;
    @Length(min = 5)
    private BigDecimal productPrice;
    @Length(min = 1)
    private int productQuanlity;
    @Length(min = 1)
    private Integer productSelled;
    private Timestamp createOn;
    private Timestamp updateOn;
    private boolean status;

    @Id
    @Column(name = "product_id")
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "category_id")
    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "warehouse_id")
    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(long warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_description")
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Basic
    @Column(name = "product_image")
    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @Basic
    @Column(name = "product_price")
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "product_quanlity")
    public int getProductQuanlity() {
        return productQuanlity;
    }

    public void setProductQuanlity(int productQuanlity) {
        this.productQuanlity = productQuanlity;
    }

    @Basic
    @Column(name = "product_selled")
    public Integer getProductSelled() {
        return productSelled;
    }

    public void setProductSelled(Integer productSelled) {
        this.productSelled = productSelled;
    }

    @Basic
    @Column(name = "create_on")
    public Timestamp getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Timestamp createOn) {
        this.createOn = createOn;
    }

    @Basic
    @Column(name = "update_on")
    public Timestamp getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Timestamp updateOn) {
        this.updateOn = updateOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return productId == that.productId &&
                categoryId == that.categoryId &&
                warehouseId == that.warehouseId &&
                productQuanlity == that.productQuanlity &&
                Objects.equals(productCode, that.productCode) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productDescription, that.productDescription) &&
                Objects.equals(productImage, that.productImage) &&
                Objects.equals(productPrice, that.productPrice) &&
                Objects.equals(productSelled, that.productSelled) &&
                Objects.equals(createOn, that.createOn) &&
                Objects.equals(updateOn, that.updateOn) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productCode, categoryId, warehouseId, productName, productDescription, productImage, productPrice, productQuanlity, productSelled, createOn, updateOn,status);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
