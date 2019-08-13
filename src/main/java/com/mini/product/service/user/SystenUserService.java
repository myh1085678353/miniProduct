package com.mini.product.service.user;

import com.mini.product.model.entity.user.SystemUserEntity;
import com.mini.product.model.reponsitory.user.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystenUserService {

    @Autowired
    SystemUserRepository systemUserRepository;

    public List<SystemUserEntity> findAll(){
        return systemUserRepository.findAll();
    }

    public void save(SystemUserEntity systemUserEntity){
        systemUserRepository.save(systemUserEntity);
    }

    public SystemUserEntity login(SystemUserEntity systemUserEntity){
        return systemUserRepository.findFirstByNameAndPassword(systemUserEntity.getName(),systemUserEntity.getPassword());
    }


}
