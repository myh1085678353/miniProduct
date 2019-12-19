package com.mini.product.module.system.restful;

import com.mini.product.common.response.ResponseUtil;
import com.mini.product.module.system.entity.SystemMenuEntity;

import com.mini.product.module.system.service.SystemMenuService;
import com.mini.product.module.system.service.impl.SystemMenuServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${CommonValue.base_url}/menu")
public class SystemMenuController {

    private static Logger log = LoggerFactory.getLogger(SystemMenuController.class);

    @Autowired
    SystemMenuService systemMenuService;

    @RequestMapping("getMenuAll")
    public ResponseUtil getMenuAll(){
        ResponseUtil responseUtil = ResponseUtil.buildSuccess();
        Map<String,Object> res = systemMenuService.getMenuAll();
        responseUtil.setData(res);
        return responseUtil;
    }
}
