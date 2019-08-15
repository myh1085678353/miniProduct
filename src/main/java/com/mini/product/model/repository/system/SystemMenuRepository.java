package com.mini.product.model.repository.system;

import com.mini.product.model.entity.system.SystemMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemMenuRepository extends JpaRepository<SystemMenuEntity,Integer> {

    List<SystemMenuEntity> findAllByOrderBySequenceAsc();
}
