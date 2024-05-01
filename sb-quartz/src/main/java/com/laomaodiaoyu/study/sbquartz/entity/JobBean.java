package com.laomaodiaoyu.study.sbquartz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //全参构造
@NoArgsConstructor  //无参构造
public class JobBean {

    /**
     * 任务名
     */
    private String jobName;
    /**
     * 任务类
     */
    private String jobClass;


    /**
     * cron表达式
     */
    private String cronExpression;


}
