package com.mini.product;

import com.mini.product.module.system.entity.SystemInstitutionsEntity;
import com.mini.product.module.system.service.impl.SystemInstitutionsServiceImpl;
import com.mini.product.module.user.service.impl.SystemUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest

public class InstistutionTest {
    @Autowired
    SystemInstitutionsServiceImpl service;

    SystemInstitutionsEntity entity;
    @Autowired
    SystemUserServiceImpl test ;
    @Test
    public void save(){
        SystemInstitutionsEntity entity = new SystemInstitutionsEntity();
        Date now=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM.dd-HH:mm:ss");
        String tablename=dateFormat.format(now);
        entity.setId(001);
        entity.setAddress("啊啊啊");
        entity.setDeleted(0);
        entity.setName("啊啊啊");
        entity.setTime(tablename);
        service.save(entity);

    }
}
