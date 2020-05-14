package com.soft1851.springboot.task.schedule.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: YangJinG
 * @Date: 2020/5/14
 * @Description:
 */
@Component
public class Task2 {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dtf.format( LocalDateTime.now()));
    }
}
