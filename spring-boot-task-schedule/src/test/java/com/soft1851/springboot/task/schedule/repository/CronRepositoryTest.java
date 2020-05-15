package com.soft1851.springboot.task.schedule.repository;

import com.soft1851.springboot.task.schedule.model.Cron;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;



@SpringBootTest
class CronRepositoryTest {
    @Resource
    private CronRepository cronRepository;

    @Test
    void findCronByCronIdEquals() {
        Cron cron = cronRepository.findCronByCronIdEquals(3);
        System.out.println(cron);
    }

    @Test
    void updateCron() {
        cronRepository.updateCron("0/8 * * * * ?", 1);
    }

}