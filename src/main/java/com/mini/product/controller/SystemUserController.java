package com.mini.product.controller;

import com.mini.product.model.entity.SystemUserEntity;
import com.mini.product.response.RespnseUtil;
import com.mini.product.service.SystenUserService;
import com.mini.product.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${CommonValue.base_url}/user")
public class SystemUserController {
    private static Logger log = LoggerFactory.getLogger(SystemUserController.class);

    @Autowired
    SystenUserService systenUserService;

    @RequestMapping("findAll")
    public List<SystemUserEntity> findAll(){
        return systenUserService.findAll();
    }

    @RequestMapping("saveTest")
    public void saveTest(){
        SystemUserEntity systemUserEntity = new SystemUserEntity();
        systemUserEntity.setName("root");
        systemUserEntity.setPassword(StringUtil.setPassword("123456"));
        systemUserEntity.setUid(StringUtil.getUUID32());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        systemUserEntity.setCreateTime(sdf.format(new Date()));

        systenUserService.save(systemUserEntity);
    }

    @RequestMapping("login")
    public RespnseUtil login(SystemUserEntity systemUserEntity){
        log.info(systemUserEntity.getName()+" login in "+System.currentTimeMillis());

        systemUserEntity.setPassword(StringUtil.setPassword(systemUserEntity.getPassword()));
        systemUserEntity = systenUserService.login(systemUserEntity);

        Map<String,Object> res = new HashMap<>();
        res.put("data",systemUserEntity);
        return RespnseUtil.SUCCESS(res);
    }
}
