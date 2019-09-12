package com.mini.product.service.user;

import com.mini.product.model.entity.user.UserLoginData;
import com.mini.product.model.repository.user.UserLoginDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

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
