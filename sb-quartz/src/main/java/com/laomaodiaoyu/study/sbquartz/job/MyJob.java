package com.laomaodiaoyu.study.sbquartz.job;

import org.quartz.*;

@DisallowConcurrentExecution    //任务处理时间超过了定时的时间，禁止并发，
@PersistJobDataAfterExecution   //持久化jobdata内容
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //context -定时任务执行的环境（上下文）

        JobDetail jobDetail = context.getJobDetail();
        //输入 任务的名字
//        System.out.println("任务名称："+jobDetail.getKey().getName());
//        System.out.println("任务分组："+jobDetail.getKey().getGroup());
//        System.out.("任务类名："+jobDetail.getKey().getClass());
//
//        System.out.println("本次执行时间："+context.getFireTime());
//        System.out.println("下次执行时间："+context.getNextFireTime());
        //记录任务执行次数
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        Integer count = (Integer) jobDataMap.get("count");
        System.out.println("任务"+jobDetail.getKey().getName()+"第"+count+"执行，本次执行时间："+context.getFireTime());
        jobDataMap.put("count",++count);
        //打印jobdetail的哈希码
//        System.out.println("System.identityHashCode(jobDetail)="+System.identityHashCode(jobDetail));
    }
}
