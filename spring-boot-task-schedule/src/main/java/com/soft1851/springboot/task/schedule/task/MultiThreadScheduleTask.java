package com.soft1851.springboot.task.schedule.task;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.http.HttpUtil;
import com.soft1851.springboot.task.schedule.model.Coder;
import com.soft1851.springboot.task.schedule.repository.CoderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.awt.*;

/**
 * @Author: YangJinG
 * @Date: 2020/5/17
 * @Description:
 */
@Slf4j
@Configuration
@Component
public class MultiThreadScheduleTask {
    @Resource
    private CoderRepository coderRepository;
    @Async
    @Scheduled(fixedRate = 1000)
    public void first(){
        Console.log("第一个异步定时任务，{}，当前线程{}", DateUtil.now(), Thread.currentThread().getName());
    }

    @Async
    @Scheduled(fixedRate = 3000)
    public void second(){
        Console.log("Task two，{}，current thread:{}", RandomUtil.randomInt(10,100), Thread.currentThread().getName());
    }

    @Async
    @Scheduled(fixedDelay = 2000)
    public void getCoder(){
        int index = RandomUtil.randomInt(1,2);
        Coder coder = coderRepository.findById(1).get();
        download(coder);
    }

    @Async
//    @Scheduled(cron = "0 57 10 * * ?")
    public void download(Coder coder){
        String template = "D:/code/{}.jpg";
        String path = StrUtil.format(template, IdUtil.simpleUUID());
        HttpUtil.downloadFile(coder.getAvatar(), FileUtil.file(path));
        getQrCode(coder.getUrl(),path);
    }

    @Async
//    @Scheduled(cron = "0 57 10 * * ?")
    public void getQrCode(String content,String logo){
        String template = "D:/code/{}.jpg";
        String file  = StrUtil.format(template,IdUtil.simpleUUID());
        QrConfig config = new QrConfig(300, 300);
        config.setImg(logo);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.BLACK.getRGB());
        // 设置背景色（灰色）
        config.setBackColor(Color.GRAY.getRGB());
        QrCodeUtil.generate(content, config,FileUtil.file(file));
    }
}