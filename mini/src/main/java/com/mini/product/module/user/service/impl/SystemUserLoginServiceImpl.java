package com.mini.product.module.user.service.impl;

import com.mini.product.module.user.repository.SystemUserLoginRepository;
import com.mini.product.module.user.entity.SystemUserLoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserLoginServiceImpl {

    @Autowired
    SystemUserLoginRepository systemUserLoginRepository;

    public void saveUserLogin(SystemUserLoginEntity systemUserLoginEntity){
        systemUserLoginRepository.save(systemUserLoginEntity);
    }

    public List<SystemUserLoginEntity> findLoginDataByUid(String uid){
        return systemUserLoginRepository.findAllByUidAndTokenIsNotNull(uid);
    }

    public List<SystemUserLoginEntity> findLoginOutDataByUid(String uid){
        return systemUserLoginRepository.findAllByUidAndLoginOutTimeNull(uid);
    }

    public void savAll(List<SystemUserLoginEntity> systemUserLoginEntities){
        systemUserLoginRepository.saveAll(systemUserLoginEntities);
    }

    public List<SystemUserLoginEntity> findLoginDataByToken(String token){
        return systemUserLoginRepository.findAllByToken(token);
    }
}
