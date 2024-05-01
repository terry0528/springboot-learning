package com.laomaodiaoyu.study.sbinterceptor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/interceptor")
    public String hello(){
        return "hello interceptor";
    }
}
