package com.mini.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("${CommonValue.base_url}/text")
public class textController {

    private static Logger log = LoggerFactory.getLogger(textController.class);

    @RequestMapping("text1")
    public void text1(HttpSession session){
        log.info("token text:"+session.getId());
    }

}
