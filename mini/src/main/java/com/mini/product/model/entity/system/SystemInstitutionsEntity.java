package com.mini.product.model.entity.system;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.*;
@Entity
@Table(name="sys_institutions")
public class SystemInstitutionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "org_name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "creat_time")
    private String time;
    @Column(name = "deleted")
    private int deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "SystemInstitutionsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", time=" + time +
                ", deleted=" + deleted +
                '}';
    }
}
