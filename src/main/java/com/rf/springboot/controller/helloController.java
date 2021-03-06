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
public class helloController {

    public static final Logger logger = LoggerFactory.getLogger(helloController.class);

    @RequestMapping("/hello")
    public String hello(){
        logger.info("enter hello test");
        return "hello";
    }

    @RequestMapping("/timeout")
    public String timeout(){
        try{
            //睡5秒，网关Hystrix3秒超时，会触发熔断降级操作
            Thread.sleep(6000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "timeout";
    }

}
