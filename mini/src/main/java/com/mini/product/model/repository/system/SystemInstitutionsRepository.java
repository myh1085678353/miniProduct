package com.mini.product.model.repository.system;

import com.mini.product.model.entity.system.SystemInstitutionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemInstitutionsRepository extends JpaRepository<SystemInstitutionsEntity,Integer> {
    public SystemInstitutionsEntity findFirstByIdAndDeleted(Integer id,Integer deleeted);
}
