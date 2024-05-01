package com.laomaodiaoyu.study.sbfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.laomaodiaoyu.study.sbfilter.filter")
public class SbFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbFilterApplication.class, args);
    }

}
