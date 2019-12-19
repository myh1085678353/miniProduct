package com.mini.product.module.user.service;

import com.mini.product.module.user.entity.SystemUserEntity;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 用户服务
 */
public interface SystemUserService {

    List<SystemUserEntity> findAll();

    SystemUserEntity save(SystemUserEntity systemUserEntity);

    SystemUserEntity login(SystemUserEntity systemUserEntity);

    SystemUserEntity findFirstByUid(String uid);

    Map<String, Object> getLoginUser(HttpSession session);
}
