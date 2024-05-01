package com.laomao.study.pojo;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Father implements InitializingBean, DisposableBean {

    @Autowired
    private Son son;

    @PostConstruct
    public void initMethod(){
        System.out.println("Father...initMethod...执行了");
    }

    @PreDestroy
    public void destroyMethod(){
        System.out.println("Father...destroyMethod...执行了");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean...afterPropertiesSet...执行了");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean...destroy...执行了");
    }
}
