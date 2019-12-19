package com.mini.product.module.system.repository;

import com.mini.product.module.system.entity.SystemInstitutionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemInstitutionsRepository extends JpaRepository<SystemInstitutionsEntity,Integer> {
    public SystemInstitutionsEntity findFirstByIdAndDeleted(Integer id,Integer deleeted);
}
