package com.laomaodiaoyu.study.sbquartz.config;

import com.laomaodiaoyu.study.sbquartz.job.MyJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class QuartzConfig {

    @Bean(value = "jobDetailTest")
    public JobDetail jobDetail(){
        return JobBuilder
                .newJob(MyJob.class)
                .storeDurably() //持久化的
                .withIdentity("job1","group1")
                .usingJobData("count",1)    //共享数据的初始化
                .build();
    }


    @Bean(value = "triggerTest")
    public Trigger trigger(@Qualifier("jobDetailTest") JobDetail jobDetail){
        //cor 表达式
        String corExpression = "0/2 * * * * ? *";
        return TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1","group1")
                .forJob(jobDetail)
                .withSchedule(CronScheduleBuilder.cronSchedule(corExpression)) //时间规则
                .build();
    }
}
