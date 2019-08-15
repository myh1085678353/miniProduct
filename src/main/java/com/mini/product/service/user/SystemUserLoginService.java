package com.mini.product.service.user;

import com.mini.product.model.entity.user.SystemUserLoginEntity;
import com.mini.product.model.repository.user.SystemUserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserLoginService {

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
}
