package com.mini.product.module.user.service.impl;

import com.mini.product.module.user.entity.UserLoginData;
import com.mini.product.module.user.repository.UserLoginDataRepository;
import com.mini.product.module.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    UserLoginDataRepository userLoginDataRepository;

    public UserLoginData userLogin(UserLoginData userLoginData){
        return userLoginDataRepository.userLogin(userLoginData);
    }

    public UserLoginData getUserInfo(String token){
        return userLoginDataRepository.getUserInfo(token);
    }

    public void userLogout(String token){
        userLoginDataRepository.userLogout(token);
    }
}
