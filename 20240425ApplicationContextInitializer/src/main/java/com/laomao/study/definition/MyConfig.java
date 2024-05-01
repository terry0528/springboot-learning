package com.laomao.study.definition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public String aa(){
        return "我爱美女";
    }
}
