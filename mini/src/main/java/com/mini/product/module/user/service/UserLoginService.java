package com.mini.product.module.user.service;

import com.mini.product.module.user.entity.UserLoginData;

public interface UserLoginService {

    UserLoginData userLogin(UserLoginData userLoginData);

    UserLoginData getUserInfo(String token);

    void userLogout(String token);
}
