package com.soft1851.springboot.task.schedule.task;

import com.soft1851.springboot.task.schedule.repository.CronRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @ClassName AutoTask
 * @Description TODO
 * @Author YangJinG
 * @Date 2020/5/15
 **/
@Slf4j
//@Component
public class AutoTask implements SchedulingConfigurer {
    @Resource
    protected CronRepository cronRepository;
    private String newCron;
    private Integer cronId = 1;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> {
                },
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cronRepository.findCronByCronIdEquals(cronId).getCron();
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron)) {
                        log.info("cron不能为空");
                    }
                    //2.3 返回执行周期
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}