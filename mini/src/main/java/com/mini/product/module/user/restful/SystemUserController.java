package com.mini.product.module.user.restful;

import com.mini.product.enums.SystemEnum;
import com.mini.product.module.user.entity.SystemUserEntity;
import com.mini.product.module.user.entity.SystemUserLoginEntity;
import com.mini.product.module.user.entity.UserLoginData;
import com.mini.product.common.response.ResponseUtil;
import com.mini.product.module.user.service.SystemUserLoginService;
import com.mini.product.module.user.service.SystemUserService;
import com.mini.product.module.user.service.UserLoginService;
import com.mini.product.module.user.service.impl.SystemUserLoginServiceImpl;
import com.mini.product.module.user.service.impl.SystemUserServiceImpl;
import com.mini.product.module.user.service.impl.UserLoginServiceImpl;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    /**
     * 登录
     * 获取sessionId为token，request的url
     * 将token放入response
     * @param systemUserEntity
     * @param session
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @CrossOrigin(allowedHeaders = "token")
    @RequestMapping("login")
    public ResponseUtil login(SystemUserEntity systemUserEntity, HttpSession session, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String token = session.getId();
        log.info("token:"+token);
        log.info(systemUserEntity.getName()+" login in "+System.currentTimeMillis());
        String ip = IPUtil.getIpAddress(httpServletRequest);
        log.info("request ip:"+ ip);

        systemUserEntity = systemUserService.login(systemUserEntity);   //查找用户信息

        StringBuffer requestServerpath = httpServletRequest.getRequestURL();
        requestServerpath.delete(requestServerpath.indexOf("/", 7), requestServerpath.length());

        if(systemUserEntity == null){
            return new ResponseUtil(SystemEnum.Error_User.toString());
        }
        if(systemUserEntity.getDeleted() == 1){
            return new ResponseUtil(SystemEnum.Error_User_Deleted.toString());
        }

//        systemUserLoginService.saveUserLogin(systemUserEntity,token,ip,requestServerpath.toString());


        UserLoginData userLoginData = userLoginService.userLogin(systemUserEntity,token,requestServerpath.toString());
        httpServletResponse.addHeader("token", userLoginData.getToken());
        httpServletResponse.addHeader("Access-Control-Expose-Headers", "token");

        return new ResponseUtil(SystemEnum.Success_User_Login.toString());
    }

    /**
     * 登出，并设置session作废
     * @param session
     * @param servletRequest
     * @return
     */
    @CrossOrigin(allowedHeaders = "token")
    @RequestMapping("logout")
    public ResponseUtil logout(HttpSession session,HttpServletRequest servletRequest){
        String token = servletRequest.getHeader("token");
        if(token == null){
            token = session.getId();
        }
        UserLoginData userLoginData = userLoginService.getUserInfo(token);
//        List<SystemUserLoginEntity> LogoutData = systemUserLoginService.findLoginOutDataByUid(userLoginData.getSystemUserEntity().getUid());
//        LogoutData.forEach(logoutData ->logoutData.setLoginOutTime(new Date()));
//        systemUserLoginService.savAll(LogoutData);
        session.invalidate();   //seesion作废
        return new ResponseUtil(SystemEnum.Success_User_LoginOut.toString());
    }

    /**
     * 获取登录用户信息
     * @param session
     * @return
     */
    @RequestMapping("getLoginUser")
    public ResponseUtil getLoginUser(HttpSession session){
        String uid = (String)session.getAttribute("uid");
        if(uid == null || "".equals(uid)){
            return ResponseUtil.buildError();
        }
        SystemUserEntity systemUserEntity = systemUserService.findFirstByUid(uid);
        if(systemUserEntity == null){
            return ResponseUtil.buildError();
        }
        ResponseUtil responseUtil = ResponseUtil.buildSuccess();
        systemUserEntity.setPassword(null);
        Map<String,Object> res = new HashMap<>();
        res.put("user",systemUserEntity);
        responseUtil.setData(res);
        return responseUtil;
    }

    /**
     * 注册，没有页面显示，直接采用url的方式注册
     * @param systemUserEntity
     * @return
     */
    @RequestMapping("registered")
    public ResponseUtil registered(SystemUserEntity systemUserEntity){
        systemUserEntity = systemUserService.save(systemUserEntity);
        ResponseUtil responseUtil = ResponseUtil.buildSuccess();
        return responseUtil;
    }
}
