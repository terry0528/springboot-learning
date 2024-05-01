package com.laomaodiaoyu.study.sbfilter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/filter")
    public String hello(){
        return "hello filter.";
    }
}
