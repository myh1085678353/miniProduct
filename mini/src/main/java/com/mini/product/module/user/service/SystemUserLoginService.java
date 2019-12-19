package com.mini.product.module.user.service;

import com.mini.product.module.user.entity.SystemUserEntity;
import com.mini.product.module.user.entity.SystemUserLoginEntity;

import java.util.List;

/**
 * 用户登录
 */
public interface SystemUserLoginService {
    SystemUserLoginEntity saveUserLogin(SystemUserEntity systemUserEntity,String token,String ip,String requestServerpath);

    List<SystemUserLoginEntity> findLoginDataByUid(String uid);

    List<SystemUserLoginEntity> findLoginOutDataByUid(String uid);

    void savAll(List<SystemUserLoginEntity> systemUserLoginEntities);

    List<SystemUserLoginEntity> findLoginDataByToken(String token);
}
