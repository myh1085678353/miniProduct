package com.mini.product.module.user.service.impl;

import com.mini.product.module.user.entity.SystemUserEntity;
import com.mini.product.module.user.repository.SystemUserLoginRepository;
import com.mini.product.module.user.entity.SystemUserLoginEntity;
import com.mini.product.module.user.service.SystemUserLoginService;
import com.mini.product.module.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SystemUserLoginServiceImpl implements SystemUserLoginService {

    @Autowired
    SystemUserLoginRepository systemUserLoginRepository;

    @Autowired
    SystemUserLoginService systemUserLoginService;

    @Autowired
    UserLoginService userLoginService;


    public SystemUserLoginEntity saveUserLogin(SystemUserEntity systemUserEntity,String token,String ip,String requestServerpath){
        List<SystemUserLoginEntity> loginData = systemUserLoginService.findLoginDataByUid(systemUserEntity.getUid());
        loginData.forEach(loginEntity -> userLoginService.userLogout(loginEntity.getToken()));  //按照token清除缓存,保证只有一个终端登录

        SystemUserLoginEntity systemUserLoginEntity = new SystemUserLoginEntity();
        systemUserLoginEntity.setUid(systemUserEntity.getUid());
        systemUserLoginEntity.setLoginName(systemUserEntity.getName());
        systemUserLoginEntity.setToken(token);
        systemUserLoginEntity.setLoginTime(new Date());
        systemUserLoginEntity.setIp(ip);
        systemUserLoginEntity.setAddress(requestServerpath);
        systemUserLoginEntity.setCreateId(systemUserEntity.getId());
        systemUserLoginEntity.setCreateTime(new Date());
        return systemUserLoginRepository.save(systemUserLoginEntity);
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
