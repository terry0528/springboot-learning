package com.laomao.study;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        //获取自定义注入的属性
        /*String appName = context.getEnvironment().getProperty("appName");
        System.out.println("自定义注入的appName："+appName);*/

        //AnnotationConfigServletWebServerApplicationContext: 最终得到的容器类型
        /*System.out.println(context.getClass());

        Application appBean = context.getBean(Application.class);
        System.out.println(appBean);*/

        //获取BeanDefinintion对象
       /* ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        BeanDefinition userBdf = beanFactory.getBeanDefinition("user");
        BeanDefinition aaBdf = beanFactory.getBeanDefinition("aa");
        System.out.println(userBdf.getClass());
        System.out.println(aaBdf.getClass());*/
//        System.out.println(context.getBean("teacher"));
    }

}
