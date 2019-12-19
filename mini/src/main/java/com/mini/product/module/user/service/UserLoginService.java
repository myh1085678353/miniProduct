package com.mini.product.module.user.service;

import com.mini.product.module.user.entity.SystemUserEntity;
import com.mini.product.module.user.entity.UserLoginData;

public interface UserLoginService {

    UserLoginData userLogin(SystemUserEntity systemUserEntity, String token, String requestServerpath);

    UserLoginData getUserInfo(String token);

    void userLogout(String token);
}
