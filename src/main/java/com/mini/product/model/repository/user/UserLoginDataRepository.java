package com.mini.product.model.repository.user;

import com.mini.product.model.entity.user.UserLoginData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@CacheConfig(cacheNames = "user_login_data")
@Repository
public class UserLoginDataRepository {

    private Logger log = LoggerFactory.getLogger(UserLoginDataRepository.class);

    @CachePut(key = "#p0.token")
    public UserLoginData userLogin(UserLoginData userLoginData){
        log.info("userLoginData Token is:"+userLoginData.getToken());
        return userLoginData;
    }

    @Cacheable(key = "#p0")
    public UserLoginData getUserInfo(String token){
        log.info("没有走缓存");
        return null;
    }

    @CacheEvict(key = "#p0")
    public void userLogout(String token){

    }

}
