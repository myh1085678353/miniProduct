package com.mini.product.module.user.service;

import com.mini.product.module.user.entity.SystemUserLoginEntity;

import java.util.List;

/**
 * 用户登录
 */
public interface SystemUserLoginService {
    void saveUserLogin(SystemUserLoginEntity systemUserLoginEntity);

    List<SystemUserLoginEntity> findLoginDataByUid(String uid);

    List<SystemUserLoginEntity> findLoginOutDataByUid(String uid);

    void savAll(List<SystemUserLoginEntity> systemUserLoginEntities);

    List<SystemUserLoginEntity> findLoginDataByToken(String token);
}
