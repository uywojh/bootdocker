package com.rf.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wuwei
 * @Date:2020-02-22 23:19
 */
@RestController
public class helloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
