package com.mini.product.service.system;

import com.mini.product.model.entity.system.SystemInstitutionsEntity;
import com.mini.product.model.repository.system.SystemInstitutionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemInstitutionsService {
    @Autowired
    SystemInstitutionsRepository systemInstitutionsRepository;

    public List<SystemInstitutionsEntity> findall(){return systemInstitutionsRepository.findAll();}

    public void save(SystemInstitutionsEntity systemInstitutionsEntity) {
        systemInstitutionsRepository.save(systemInstitutionsEntity);
    }

    public SystemInstitutionsEntity findFristByUid(Integer id){
        return systemInstitutionsRepository.findFirstByIdAndDeleted(id,0);
    }

}
