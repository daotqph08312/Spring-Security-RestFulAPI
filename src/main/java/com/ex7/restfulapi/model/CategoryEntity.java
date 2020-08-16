package com.ex7.restfulapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "ex03_mysql", catalog = "")
public class CategoryEntity {
    private long categoryId;
    private String categoryCode;
    @NotNull
    @NotBlank
    private String categoryName;
    @NotBlank
    private String categoryDescription;
    private Timestamp createOn;
    private Timestamp updateOn;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Id
    @Column(name = "category_id")
    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "category_code")
    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Basic
    @Column(name = "category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "category_description")
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Basic
    @Column(name = "create_on")
    public Timestamp getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Timestamp createOn) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.createOn = timestamp;
    }

    @Basic
    @Column(name = "update_on")
    public Timestamp getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Timestamp updateOn) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.updateOn = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return categoryId == that.categoryId &&
                Objects.equals(categoryCode, that.categoryCode) &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(categoryDescription, that.categoryDescription) &&
                Objects.equals(createOn, that.createOn) &&
                Objects.equals(updateOn, that.updateOn) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryCode, categoryName, categoryDescription, createOn, updateOn);
    }
}
