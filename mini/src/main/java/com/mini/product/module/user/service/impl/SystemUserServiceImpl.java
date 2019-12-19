package com.mini.product.module.user.service.impl;

import com.mini.product.module.user.entity.SystemUserEntity;
import com.mini.product.module.user.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserServiceImpl {

    @Autowired
    SystemUserRepository systemUserRepository;

    public List<SystemUserEntity> findAll(){
        return systemUserRepository.findAll();
    }

    public void save(SystemUserEntity systemUserEntity){
        systemUserRepository.save(systemUserEntity);
    }

    public SystemUserEntity login(SystemUserEntity systemUserEntity){
        return systemUserRepository.findFirstByNameAndPassword(systemUserEntity.getName(),systemUserEntity.getPassword());
    }

    public SystemUserEntity findFristByUid(String uid){
        return systemUserRepository.findFirstByUidAndDeleted(uid,0);
    }


}
