package com.mini.product.model.reponsitory.user;

import com.mini.product.model.entity.user.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRepository extends JpaRepository<SystemUserEntity,Integer> {

    SystemUserEntity findFirstByNameAndPassword(String name,String password);
}
