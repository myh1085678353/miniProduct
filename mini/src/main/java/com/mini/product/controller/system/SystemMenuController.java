package com.mini.product.controller.system;

import com.mini.product.model.entity.system.SystemMenuEntity;
import com.mini.product.response.ResponseUtil;
import com.mini.product.service.system.SystemMenuService;
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
    public ResponseUtil getMenuAll(HttpSession session){
        String uid = (String)session.getAttribute("uid");

        List<SystemMenuEntity> systemMenuEntityList = systemMenuService.getMenuAllForText();

        List<Map<String,Object>> list = systemMenuService.getTarbar(systemMenuEntityList);
        Map<String,Object> res = new HashMap<>();
        res.put("data",list);
        return ResponseUtil.SUCCESS(res);
    }
}
