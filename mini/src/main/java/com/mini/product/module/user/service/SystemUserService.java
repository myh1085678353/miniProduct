package com.mini.product.module.user.service;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用户服务
 */
public interface SystemUserService {
    Map<String,Object> getLoginUser(HttpSession session);
}
