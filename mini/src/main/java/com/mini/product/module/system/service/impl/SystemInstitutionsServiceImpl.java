package com.mini.product.module.system.service.impl;

import com.mini.product.module.system.repository.SystemInstitutionsRepository;
import com.mini.product.module.system.entity.SystemInstitutionsEntity;
import com.mini.product.module.system.service.SystemInstitutionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemInstitutionsServiceImpl implements SystemInstitutionsService {
    @Autowired
    SystemInstitutionsRepository systemInstitutionsRepository;

    public List<SystemInstitutionsEntity> findall(){return systemInstitutionsRepository.findAll();}


}
