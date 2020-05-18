package com.soft1851.springboot.task.schedule.service;



import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;



/**
 * @ClassName AsyncTaskService
 * @Description TODO
 * @Author YangJinG
 * @Date 2020/5/17
 **/
@Service
@Slf4j
public class AsyncTaskService {
    @Async
    public void asyncTask() {
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("处理数据中...");
    }
}