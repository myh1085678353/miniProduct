package com.mini.product.service.system;

import com.mini.product.model.entity.system.SystemMenuEntity;
import com.mini.product.model.repository.system.SystemMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SystemMenuService {

    @Autowired
    SystemMenuRepository systemMenuRepository;

    public List<SystemMenuEntity> getMenuAllForText(){
        return systemMenuRepository.findAllByOrderBySequenceAsc();
    }

    public List<Map<String,Object>> getTarbar(List<SystemMenuEntity> systemMenuEntities){
        List<Map<String,Object>> list = new ArrayList<>();
        systemMenuEntities.forEach(systemMenuEntity -> {
            if(systemMenuEntity.getSequence() != null){
                Map<String,Object> res = new HashMap<>();
                List<SystemMenuEntity> systemMenuEntities1 = getdl(systemMenuEntities,systemMenuEntity.getSequence());
                res.put("tarbar",systemMenuEntity);
                res.put("dl",systemMenuEntities1);

                list.add(res);
            }
        });
        return list;
    }

    public List<SystemMenuEntity> getdl(List<SystemMenuEntity> systemMenuEntities,Integer id){
        systemMenuEntities = systemMenuEntities.stream().filter(systemMenuEntity -> {
            if(systemMenuEntity.getPlid() == id)
                return true;
            return false;
        }).collect(Collectors.toList());

        return systemMenuEntities;
    }
}
