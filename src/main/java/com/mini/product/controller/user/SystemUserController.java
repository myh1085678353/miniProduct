package com.mini.product.controller.user;

import com.mini.product.enums.SystemEnum;
import com.mini.product.model.entity.user.SystemUserEntity;
import com.mini.product.model.entity.user.SystemUserLoginEntity;
import com.mini.product.model.entity.user.UserLoginData;
import com.mini.product.response.ResponseUtil;
import com.mini.product.service.user.SystemUserLoginService;
import com.mini.product.service.user.SystemUserService;
import com.mini.product.service.user.UserLoginService;
import com.mini.product.util.IPUtil;
import com.mini.product.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${CommonValue.base_url}/user")
public class SystemUserController {
    private static Logger log = LoggerFactory.getLogger(SystemUserController.class);

    @Autowired
    SystemUserService systemUserService;

    @Autowired
    SystemUserLoginService systemUserLoginService;

    @Autowired
    UserLoginService userLoginService;

    @CrossOrigin(allowedHeaders = "token")
    @RequestMapping("login")
    public ResponseUtil login(SystemUserEntity systemUserEntity, HttpSession session, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String token = session.getId();
        log.info("token:"+token);
        log.info(systemUserEntity.getName()+" login in "+System.currentTimeMillis());
        String ip = IPUtil.getIpAddress(httpServletRequest);
        log.info("request ip:"+ ip);

        systemUserEntity.setPassword(StringUtil.setPassword(systemUserEntity.getPassword()));
        systemUserEntity = systemUserService.login(systemUserEntity);   //查找用户信息

        StringBuffer requestServerpath = httpServletRequest.getRequestURL();
        requestServerpath.delete(requestServerpath.indexOf("/", 7), requestServerpath.length());

        if(systemUserEntity == null){
            return ResponseUtil.Error(SystemEnum.Error_User.toString());
        }
        if(systemUserEntity.getDeleted() == 1){
            return ResponseUtil.Error(SystemEnum.Error_User_Deleted.toString());
        }
        List<SystemUserLoginEntity> loginData = systemUserLoginService.findLoginDataByUid(systemUserEntity.getUid());
        loginData.forEach(loginEntity -> userLoginService.userLogout(loginEntity.getToken()));  //按照token清除缓存,保证只有一个终端登录

        SystemUserLoginEntity systemUserLoginEntity = new SystemUserLoginEntity();
        systemUserLoginEntity.setUid(systemUserEntity.getUid());
        systemUserLoginEntity.setLoginName(systemUserEntity.getName());
        systemUserLoginEntity.setSessionId(session.getId());
        systemUserLoginEntity.setToken(token);
        systemUserLoginEntity.setLoginTime(new Date());
        systemUserLoginEntity.setIp(ip);
        systemUserLoginEntity.setAddress(requestServerpath.toString());
        systemUserLoginEntity.setCreateId(systemUserEntity.getId());
        systemUserLoginEntity.setCreateTime(new Date());

        systemUserLoginService.saveUserLogin(systemUserLoginEntity);
        UserLoginData userLoginData = new UserLoginData();
        userLoginData.setLoginName(systemUserEntity.getName());
        userLoginData.setRequestPath(requestServerpath.toString());
        userLoginData.setToken(token);
        userLoginData.setSystemUserEntity(systemUserEntity);

        userLoginService.userLogin(userLoginData);
        httpServletResponse.addHeader("token", userLoginData.getToken());
        httpServletResponse.addHeader("Access-Control-Expose-Headers", "token");

        return ResponseUtil.SUCCESS(SystemEnum.Success_User_Login.toString());
    }

    @CrossOrigin(allowedHeaders = "token")
    @RequestMapping("logout")
    public ResponseUtil logout(HttpSession session,HttpServletRequest servletRequest){
        String token = servletRequest.getHeader("token");
        if(token == null){
            token = session.getId();
        }
        UserLoginData userLoginData = userLoginService.getUserInfo(token);
        List<SystemUserLoginEntity> LogoutData = systemUserLoginService.findLoginOutDataByUid(userLoginData.getSystemUserEntity().getUid());
        LogoutData.forEach(logoutData ->logoutData.setLoginOutTime(new Date()));
        systemUserLoginService.savAll(LogoutData);
        session.invalidate();   //seesion作废

        return ResponseUtil.SUCCESS(SystemEnum.Success_User_LoginOut.toString());
    }

    @RequestMapping("getLoginUser")
    public ResponseUtil getLoginUser(HttpSession session){
        String uid = (String)session.getAttribute("uid");
        if(uid == null || uid.equals("")){
            return ResponseUtil.Error(SystemEnum.Error_Login_Action.toString());
        }
        SystemUserEntity systemUserEntity = systemUserService.findFristByUid(uid);
        if(systemUserEntity == null){
            return ResponseUtil.Error(SystemEnum.Error_User_Not_Exist.toString());
        }
        systemUserEntity.setPassword("");
        Map<String,Object> res = new HashMap<>();
        res.put("user",systemUserEntity);

        return ResponseUtil.SUCCESS(res);
    }
}
