package com.mini.product.module.system.service;

import com.mini.product.module.system.entity.SystemMenuEntity;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 系统菜单
 * @author hu
 * @date 2019/12/19 11.09
 */
public interface SystemMenuService {
    //获取菜单
    Map<String,Object> getMenuAll();
}
