package com.mini.product.model.reponsitory;

import com.mini.product.model.entity.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserReponsitory extends JpaRepository<SystemUserEntity,Integer> {

    SystemUserEntity findFirstByNameAndPasswordAndDeleted(String name,String password,Integer delete);
}
