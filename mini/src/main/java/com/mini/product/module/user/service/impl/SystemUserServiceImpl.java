package com.mini.product.module.user.service.impl;

import com.mini.product.module.user.entity.SystemUserEntity;
import com.mini.product.module.user.repository.SystemUserRepository;
import com.mini.product.module.user.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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
        return systemUserRepository.save(systemUserEntity);
    }

    public SystemUserEntity login(SystemUserEntity systemUserEntity){
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
