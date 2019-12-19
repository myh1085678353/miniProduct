package com.mini.product.module.system.restful;


import com.mini.product.module.system.service.SystemInstitutionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${CommonValue.base_url}/institutions")
public class SystemInstitutionsController {
    @Autowired
    SystemInstitutionsService systemInstitutionsService;
}
