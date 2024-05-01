package com.laomao.study.initialize;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Animal  implements InitializingBean, DisposableBean {


    //销毁
    @Override
    public void destroy() throws Exception {
        System.out.println("Animal...destroy...");
    }
    //初始化方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Animal...afterPropertiesSet...");
    }

    //PostConstructor,PreDestroy，提供初始化方法和销毁方法的注解，
    // 这两个注解的顺序先于 实现 InitializingBean, DisposableBean 的bean
    @PostConstruct
    public void initMethod(){
        System.out.println("Animal...PostConstructor...initMethod...");
    }

    @PreDestroy
    public void destroyMethod(){
        System.out.println("Animal...PreDestroy...destroyMethod...");
    }
}
