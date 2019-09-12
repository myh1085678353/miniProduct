package com.mini.product;

import com.mini.product.model.entity.system.SystemInstitutionsEntity;
import com.mini.product.model.repository.system.SystemInstitutionsRepository;
import com.mini.product.service.system.SystemInstitutionsService;
import com.mini.product.service.user.SystemUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest

public class InstistutionTest {
    @Autowired
    SystemInstitutionsService service;

    SystemInstitutionsEntity entity;
    @Autowired
    SystemUserService test ;
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
