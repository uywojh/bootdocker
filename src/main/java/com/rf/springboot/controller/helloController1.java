package com.rf.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wuwei
 * @Date:2020-02-22 23:19
 */
@RestController
public class helloController1 {

    public static final Logger logger = LoggerFactory.getLogger(helloController1.class);

    @RequestMapping("/hello1")
    public String hello(){
        logger.info("enter hello1 test");
        return "hello1";
    }


}
