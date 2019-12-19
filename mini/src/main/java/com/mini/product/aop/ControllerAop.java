package com.mini.product.aop;

import com.mini.product.exception.LoginErrorException;
import com.mini.product.module.user.entity.UserLoginData;
import com.mini.product.common.response.ResponseUtil;
import com.mini.product.module.user.service.impl.UserLoginServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class ControllerAop {

    private static final Logger log = LoggerFactory.getLogger(ControllerAop.class);

    @Autowired
    UserLoginServiceImpl userLoginServiceImpl;

    public static long startTime;
    public static long endTime;

    @Pointcut("execution(* com.mini.product.controller..*(..))"+
            "&& !execution(* com.mini.product.module.user.restful.SystemUserController.login(..))" +
            "&& !execution(* com.mini.product.module.user.restful.SystemUserController.logout(..))"
    )
    public void ControllerAopPointcut(){

    }

    @Before("ControllerAopPointcut()")
    public void doBefore(JoinPoint joinPoint) throws LoginErrorException {
        Signature signature = joinPoint.getSignature();
        startTime = System.currentTimeMillis();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();

        UserLoginData userLoginData = null;
        String token = request.getHeader("token");
        HttpSession session = request.getSession();

        if(token == null){
            token = session.getId();
            userLoginData = userLoginServiceImpl.getUserInfo(session.getId());
        }else{
            userLoginData = userLoginServiceImpl.getUserInfo(token);
        }
        log.info("token:"+token);

        if(userLoginData != null){
            session.setAttribute("uid",userLoginData.getSystemUserEntity().getUid());
            session.setAttribute("requestpath",userLoginData.getRequestPath());
            session.setMaxInactiveInterval(30*60);

            if(session.getAttribute("uid") == null || session.getAttribute("uid").equals("")){
                throw new LoginErrorException();
            }
        }else{
            throw new LoginErrorException();
        }
    }

    @After("ControllerAopPointcut()")
    public void doAfter(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        endTime = System.currentTimeMillis();

        long SpeedTime = endTime - startTime;
        log.info("The function " + signature.getDeclaringTypeName() + "." + signature.getName() + " spend " + SpeedTime + " ms");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = attributes.getRequest();
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("uid");
        session.removeAttribute("requestpath");
    }

    @AfterThrowing(throwing = "ex",value = "ControllerAopPointcut()")
    public ResponseUtil doAfterException(JoinPoint joinPoint,Throwable ex){
        Signature signature = joinPoint.getSignature();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute("uid");
        session.removeAttribute("requsetpath");

        endTime = System.currentTimeMillis();
        long SpeedTime = endTime - startTime;
        log.info("The function " + signature.getDeclaringTypeName() + "." + signature.getName() + "  have exception spend " + SpeedTime + " ms");
        ResponseUtil responseUtil = new ResponseUtil(ex.getMessage());
        return responseUtil;
    }

}
