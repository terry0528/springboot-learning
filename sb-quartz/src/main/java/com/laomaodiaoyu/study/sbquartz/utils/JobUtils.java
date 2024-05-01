package com.laomaodiaoyu.study.sbquartz.utils;

import com.laomaodiaoyu.study.sbquartz.entity.JobBean;
import org.quartz.*;

public class JobUtils {

    /**
     * 生成定时任务
     * @param schedule
     * @param jobBean
     */
    public static void createJob(Scheduler schedule, JobBean jobBean){
        Class<? extends Job> jobClass=null;
        JobDetail jobDetail = null;
        Trigger trigger = null;
        try {
            //反射获取job类
            jobClass = (Class<? extends Job>) Class.forName(jobBean.getJobClass());
            jobDetail = JobBuilder
                    .newJob(jobClass)
                    .storeDurably() //持久化的
                    .withIdentity(jobBean.getJobName())
                    .usingJobData("count",1)    //共享数据的初始化
                    .build();
            //定义trigger
            trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity(jobBean.getJobName()+"_trigger")
                    .forJob(jobDetail)
                    .withSchedule(CronScheduleBuilder.cronSchedule(jobBean.getCronExpression())) //时间规则
                    .build();
            schedule.scheduleJob(jobDetail,trigger);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 暂停任务
     * @param scheduler 调度器
     * @param jobName 任务名
     */
    public static void pauseJob(Scheduler scheduler,String jobName){
        JobKey jobKey= JobKey.jobKey(jobName);
        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 恢复任务
     * @param scheduler 调度器
     * @param jobName 任务名
     */
    public static void resumeJob(Scheduler scheduler,String jobName){
        JobKey jobKey= JobKey.jobKey(jobName);
        try {
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除任务
     * @param scheduler 调度器
     * @param jobName 任务名
     */
    public static void deleteJob(Scheduler scheduler,String jobName){
        JobKey jobKey= JobKey.jobKey(jobName);
        try {
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行一次任务
     * @param scheduler
     * @param jobName
     */
    public static void runJobOnce(Scheduler scheduler,String jobName){
        JobKey jobKey= JobKey.jobKey(jobName);
        try {
            //调用triggerJob API实现只执行一次任务
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 修改任务
     * @param scheduler
     * @param jobBean
     */
    public static void modfiyJob(Scheduler scheduler,JobBean jobBean){
        //获取任务触发器的唯一标识
        TriggerKey triggerKey = TriggerKey.triggerKey(jobBean.getJobName() + "_trigger");
        //通过唯一标识获取旧的触发器对象
        try {
            CronTrigger oldTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            //使用cron表达式 构建新的触发器
            String newCorn = jobBean.getCronExpression();
            CronTrigger newTrigger = oldTrigger.getTriggerBuilder()
                    .withSchedule(CronScheduleBuilder.cronSchedule(newCorn).withMisfireHandlingInstructionDoNothing())  //withMisfireHandlingInstructionDoNothing 用于忽略所有错过的任务
                    .build();
            //更新任务
            scheduler.rescheduleJob(triggerKey,newTrigger);

        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }


    }
}
