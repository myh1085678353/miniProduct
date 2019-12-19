package com.mini.product.module.system.repository;

import com.mini.product.module.system.entity.SystemMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemMenuRepository extends JpaRepository<SystemMenuEntity,Integer> {

    List<SystemMenuEntity> findAllByOrderBySequenceAsc();
}
