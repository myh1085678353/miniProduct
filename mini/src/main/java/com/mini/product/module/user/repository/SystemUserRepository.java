package com.mini.product.module.user.repository;

import com.mini.product.module.user.entity.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRepository extends JpaRepository<SystemUserEntity,Integer> {

    SystemUserEntity findFirstByNameAndPassword(String name,String password);

    SystemUserEntity findFirstByUidAndDeleted(String uid,Integer deleeted);
}
