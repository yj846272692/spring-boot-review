package com.soft1851.springboot.task.schedule.task;

import com.soft1851.springboot.task.schedule.model.User;
import com.soft1851.springboot.task.schedule.repository.UserRepository;
import com.soft1851.springboot.task.schedule.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TimeMailTask
 * @Description TODO
 * @Author YangJinG
 * @Date 2020/5/16
 **/
//@Component
@Slf4j
public class TimeMailTask {
    @Resource
    private UserRepository userRepository;
    @Resource
    private MailService mailService;

    private int count = 1;

    @Scheduled(cron = "0 43 3 * * ?")
    private void process() throws Exception {
        List<User> userList = userRepository.findUsersByBirthday();
        for (User user : userList) {
            String to = user.getMail();
            String subject = user.getUserName() + "生日快乐";
            String content = "<h2>Happy Birthday~~" + user.getUserName() + "</h2>" +
                    "<br/> <img src=\"cid:img01\" />";
            String imgPath = "D:\\spring-boot-review\\spring-boot-task-schedule\\birthday.jpg";
            Map<String, String> birthday = new HashMap<>();
            birthday.put("img01", imgPath);
            mailService.sendImgMail(to, subject, content, birthday);
            log.info(user.getUserName() + "的祝福邮件发送成功" + count++ + "次");
        }
    }
}