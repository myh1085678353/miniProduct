package com.mini.product.model.repository.user;

import com.mini.product.model.entity.user.SystemUserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemUserLoginRepository extends JpaRepository<SystemUserLoginEntity,Integer> {

    List<SystemUserLoginEntity> findAllByUidAndTokenIsNotNull(String uid);

    List<SystemUserLoginEntity> findAllByUidAndLoginOutTimeNull(String uid);

    List<SystemUserLoginEntity> findAllByToken(String token);
}
