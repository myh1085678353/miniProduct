package com.mini.product.listener;

import com.mini.product.model.entity.user.SystemUserLoginEntity;
import com.mini.product.service.user.SystemUserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.Date;
import java.util.List;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    private static Logger log = LoggerFactory.getLogger(SessionListener.class);

    @Autowired
    SystemUserLoginService systemUserLoginService;

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("---sessionCreated---");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("---sessionDestroyed---");
        HttpSession session = se.getSession();

        log.info("deletedSessionId:"+session.getId());
        List<SystemUserLoginEntity> systemUserLoginEntities = systemUserLoginService.findLoginDataByToken(session.getId());
        systemUserLoginEntities.forEach(systemUserLoginEntity -> {
            systemUserLoginEntity.setLoginOutTime(new Date());
        });
//        systemUserLoginService.savAll(systemUserLoginEntities);
    }
}
