package com.laomaodiaoyu.study.sbquartz.controller;


import com.laomaodiaoyu.study.sbquartz.entity.JobBean;
import com.laomaodiaoyu.study.sbquartz.job.MyJob;
import com.laomaodiaoyu.study.sbquartz.utils.JobUtils;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quartz")
public class QuartZController {

    @Autowired
    Scheduler scheduler;

    private String jobName="myJob";

    @RequestMapping(value = "/createJob",method = RequestMethod.GET)
    public String createJob(){
        JobBean jobBean = new JobBean(
                jobName,
                MyJob.class.getName(),
                "0/2 * * * * ? *");
        JobUtils.createJob(scheduler,jobBean);
        return "任务创建成功";
    }

    @RequestMapping(value = "/pauseJob",method = RequestMethod.GET)
    public String pauseJob(){

        JobUtils.pauseJob(scheduler,jobName);
        return "任务暂停成功";
    }

    @RequestMapping(value = "/resumeJob",method = RequestMethod.GET)
    public String resumeJob(){

        JobUtils.resumeJob(scheduler,jobName);
        return "任务暂停成功";
    }

    @RequestMapping(value = "/deleteJob",method = RequestMethod.GET)
    public String deleteJob(){

        JobUtils.deleteJob(scheduler,jobName);
        return "任务暂停成功";
    }

    @RequestMapping(value = "/runJobOnce",method = RequestMethod.GET)
    public String runJobOnce(){

        JobUtils.runJobOnce(scheduler,jobName);
        return "任务执行一次成功";
    }

    @RequestMapping(value = "/modifyJob",method = RequestMethod.GET)
    public String modifyJob(){
        JobBean jobBean = new JobBean(
                jobName,
                MyJob.class.getName(),
                "0/5 * * * * ? *");
        JobUtils.modfiyJob(scheduler,jobBean);
        return "任务修改成功";
    }






}
