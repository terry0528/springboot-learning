package com.laomao.study.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MyAppContextInitializer implements ApplicationContextInitializer {
    //IOC容器对象创建完毕后执行
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        //给上下文context对象注入环境
        //1 准备属性
        Map<String,Object> myMap = new HashMap<>() ;
        myMap.put("appName","laomaodiaoyu");

        //2 获取属性资源管理对象
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //属性资源管理对象
        MutablePropertySources propertySources = environment.getPropertySources();
        //3 注册
        propertySources.addLast(new MapPropertySource("myMap",myMap));


    }
}
