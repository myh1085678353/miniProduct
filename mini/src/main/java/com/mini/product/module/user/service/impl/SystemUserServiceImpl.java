package com.mini.product.module.user.service.impl;

import com.mini.product.module.user.entity.SystemUserEntity;
import com.mini.product.module.user.repository.SystemUserRepository;
import com.mini.product.module.user.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    SystemUserRepository systemUserRepository;

    public List<SystemUserEntity> findAll(){
        return systemUserRepository.findAll();
    }

    public SystemUserEntity save(SystemUserEntity systemUserEntity){
        return systemUserRepository.save(systemUserEntity);
    }

    public SystemUserEntity login(SystemUserEntity systemUserEntity){
        return systemUserRepository.findFirstByNameAndPassword(systemUserEntity.getName(),systemUserEntity.getPassword());
    }

    public SystemUserEntity findFirstByUid(String uid){
        return systemUserRepository.findFirstByUidAndDeleted(uid,0);
    }


}
