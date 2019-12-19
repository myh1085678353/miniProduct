package com.mini.product.module.user.service.impl;

import com.mini.product.module.user.entity.SystemUserEntity;
import com.mini.product.module.user.entity.UserLoginData;
import com.mini.product.module.user.repository.UserLoginDataRepository;
import com.mini.product.module.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    UserLoginDataRepository userLoginDataRepository;

    public UserLoginData userLogin(SystemUserEntity systemUserEntity,String token,String requestServerpath){
        UserLoginData userLoginData = new UserLoginData();
        userLoginData.setLoginName(systemUserEntity.getName());
        userLoginData.setRequestPath(requestServerpath);
        userLoginData.setToken(token);
        userLoginData.setSystemUserEntity(systemUserEntity);
        return userLoginDataRepository.userLogin(userLoginData);
    }

    public UserLoginData getUserInfo(String token){
        return userLoginDataRepository.getUserInfo(token);
    }

    public void userLogout(String token){
        userLoginDataRepository.userLogout(token);
    }
}
