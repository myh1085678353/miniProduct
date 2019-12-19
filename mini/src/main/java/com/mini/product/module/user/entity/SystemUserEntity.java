package com.mini.product.module.user.entity;

import com.mini.product.module.system.entity.SystemInstitutionsEntity;

import javax.persistence.*;

@Entity
@Table(name = "sys_user")
public class SystemUserEntity {

    private Integer id;
    private String uid;
    private String name;
    private String password;
    private SystemInstitutionsEntity systemInstitutionsEntity;
    private String createTime;
    private String createBy;
    private Integer deleted;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @OneToOne
    @JoinColumn(name = "oid",referencedColumnName = "id",insertable = false,updatable = false)
    public SystemInstitutionsEntity getSystemInstitutionsEntity() {
        return systemInstitutionsEntity;
    }

    public void setSystemInstitutionsEntity(SystemInstitutionsEntity systemInstitutionsEntity) {
        this.systemInstitutionsEntity = systemInstitutionsEntity;
    }

    @Basic
    @Column(name = "create_time")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "create_by")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "deleted")
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
