package com.mini.product.module.user.service.impl;

import com.mini.product.module.user.entity.SystemUserEntity;
import com.mini.product.module.user.repository.SystemUserRepository;
import com.mini.product.module.user.service.SystemUserService;
import com.mini.product.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    SystemUserRepository systemUserRepository;

    public List<SystemUserEntity> findAll(){
        return systemUserRepository.findAll();
    }

    public SystemUserEntity save(SystemUserEntity systemUserEntity){
        String uuid = StringUtil.getUUID32();
        systemUserEntity.setPassword(StringUtil.setPassword(systemUserEntity.getPassword()));
        systemUserEntity.setUid(uuid);
        systemUserEntity.setDeleted(0);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = dateTimeFormatter.format(LocalDateTime.now());
        systemUserEntity.setCreateTime(localTime);
        return systemUserRepository.save(systemUserEntity);
    }

    public SystemUserEntity login(SystemUserEntity systemUserEntity){
        systemUserEntity.setPassword(StringUtil.setPassword(systemUserEntity.getPassword()));
        return systemUserRepository.findFirstByNameAndPassword(systemUserEntity.getName(),systemUserEntity.getPassword());
    }

    public SystemUserEntity findFirstByUid(String uid){
        return systemUserRepository.findFirstByUidAndDeleted(uid,0);
    }


    @Override
    public Map<String, Object> getLoginUser(HttpSession session) {
        String uid = (String)session.getAttribute("uid");
        if(uid == null || "".equals(uid)){
           throw new RuntimeException();
        }
        SystemUserEntity systemUserEntity = systemUserRepository.findFirstByUidAndDeleted(uid,0);
        Map<String,Object> res = new HashMap<>();
        res.put("user",systemUserEntity);
        return null;
    }
}
