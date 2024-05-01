### 前置知识 ApplicationContextInitializer
![img_1.png](img_1.png)
1 ApplicationContextInitializer如何使用？
 - 自定义类，实现ApplicationContextInitializer接口
 - 在META-INF/spring.factories配置文件中配置自定义类

2 initializer方法什么时候执行？
 - IOC容器对象创建完成后执行，常用于环境属性注册

### 前置知识 ApplicationListener
![img.png](img.png)
1 ApplicationListener如何使用？
- 自定义类，实现ApplicationListener接口
- 在META-INF/spring.factories配置文件中配置自定义类
2 oaApplincationEvent方法什么时候执行？
- IOC窗口发布事件之后执行，通常用于资源加载，定时任务发布等

### 前置知识 BeanFactory
![img_2.png](img_2.png)
常用实现类如下面2张图
![img_3.png](img_3.png)

![img_4.png](img_4.png)

1 BeanFactory的作用？
- Bean容器的根接口，提供Bean对象的创建、配置、依赖注入等功能

2 BeanFactory常见的两个实现？
- ApplicationConfigServletServerApplicationContext
- DefaultListableBeanFactory

### 前置知识 BeanDefinintion
![img_5.png](img_5.png)
![img_6.png](img_6.png)

### 前置知识 BeanFactoryPostProcessor
![img_7.png](img_7.png)

![img_8.png](img_8.png)

### 前置知识 Aware
![img_9.png](img_9.png)
![img_10.png](img_10.png)

### 前置知识 InitializingBean/DisposableBean
![img_11.png](img_11.png)

### 前置知识 BeanPostProcessor
![img_12.png](img_12.png)
![img_13.png](img_13.png)

## 面试
### SpringBoot启动顺序
![img_14.png](img_14.png)
![img_15.png](img_15.png)
![img_16.png](img_16.png)

### IOC容器初始化流程
![img_17.png](img_17.png)
![img_18.png](img_18.png)
![img_19.png](img_19.png)

### Bean生命周期
![img_20.png](img_20.png)
![img_21.png](img_21.png)
![img_22.png](img_22.png)
![img_23.png](img_23.png)

### Bean循环依赖
![img_24.png](img_24.png)
![img_26.png](img_26.png)
![img_27.png](img_27.png)
![img_29.png](img_29.png)

### SpringMVC执行流程
![img_30.png](img_30.png)
![img_31.png](img_31.png)
![img_32.png](img_32.png)
