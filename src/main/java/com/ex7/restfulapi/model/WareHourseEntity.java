package com.ex7.restfulapi.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ware_hourse", schema = "ex03_mysql", catalog = "")
public class WareHourseEntity {
    private long wareId;
    private String wareCode;
    @Length(min = 20, max = 500)
    private String wareAddress;
    private Timestamp createOn;
    private Timestamp updateOn;
    private boolean status;
    @Id
    @Column(name = "ware_id")
    public long getWareId() {
        return wareId;
    }

    public void setWareId(long wareId) {
        this.wareId = wareId;
    }

    @Basic
    @Column(name = "ware_code")
    public String getWareCode() {
        return wareCode;
    }

    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }

    @Basic
    @Column(name = "ware_address")
    public String getWareAddress() {
        return wareAddress;
    }

    public void setWareAddress(String wareAddress) {
        this.wareAddress = wareAddress;
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
        WareHourseEntity that = (WareHourseEntity) o;
        return wareId == that.wareId &&
                Objects.equals(wareCode, that.wareCode) &&
                Objects.equals(wareAddress, that.wareAddress) &&
                Objects.equals(createOn, that.createOn) &&
                Objects.equals(updateOn, that.updateOn) && Objects.equals(status,status);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wareId, wareCode, wareAddress, createOn, updateOn,status);
    }
}
