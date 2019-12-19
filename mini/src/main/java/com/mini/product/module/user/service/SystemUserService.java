package com.mini.product.module.user.service;

import com.mini.product.module.user.entity.SystemUserEntity;

import java.util.List;

/**
 * 用户服务
 */
public interface SystemUserService {

    List<SystemUserEntity> findAll();

    SystemUserEntity save(SystemUserEntity systemUserEntity);

    SystemUserEntity login(SystemUserEntity systemUserEntity);

    SystemUserEntity findFirstByUid(String uid);
}
