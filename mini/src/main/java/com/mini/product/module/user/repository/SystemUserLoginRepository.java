package com.mini.product.module.user.repository;

import com.mini.product.module.user.entity.SystemUserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemUserLoginRepository extends JpaRepository<SystemUserLoginEntity,Integer> {

    List<SystemUserLoginEntity> findAllByUidAndTokenIsNotNull(String uid);

    List<SystemUserLoginEntity> findAllByUidAndLoginOutTimeNull(String uid);

    List<SystemUserLoginEntity> findAllByToken(String token);
}
