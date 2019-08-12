package com.mini.product.service;

import com.mini.product.model.entity.SystemUserEntity;
import com.mini.product.model.reponsitory.SystemUserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystenUserService {

    @Autowired
    SystemUserReponsitory systemUserReponsitory;

    public List<SystemUserEntity> findAll(){
        return systemUserReponsitory.findAll();
    }

    public void save(SystemUserEntity systemUserEntity){
        systemUserReponsitory.save(systemUserEntity);
    }

    public SystemUserEntity login(SystemUserEntity systemUserEntity){
        return systemUserReponsitory.findFirstByNameAndPasswordAndDeleted(systemUserEntity.getName(),systemUserEntity.getPassword(),0);
    }


}
