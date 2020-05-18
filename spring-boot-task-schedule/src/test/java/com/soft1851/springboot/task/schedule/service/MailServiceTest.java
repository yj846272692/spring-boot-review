package com.soft1851.springboot.task.schedule.service;


import com.soft1851.springboot.task.schedule.task.AutoTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest

class MailServiceTest {
    @Resource
    private MailService mailService;
    @Resource
    private TemplateEngine templateEngine;
    @Autowired
    JavaMailSenderImpl javaMailSender;
    /**
     * 发送纯文本
     */
    @Test
    void  sendMail(){
        String to = "846272692@qq.com";
        String subject = "Springboot 发送简单文本邮件";
        String content = "<h3>Springboot 简单文本邮件 </h3>";
        mailService.sendSimpleTextMail(to,subject,content);
    }

    /**
     * 发送HTML
     * @throws MessagingException
     */
    @Test
    void sendHtmlMail() throws MessagingException {
        String to = "846272692@qq.com";
        String subject = "springboot发送HTML邮件";
        String content = "<h3>第一封springbootHTML邮件</h3>";
        mailService.sendHtmlMail(to,subject,content);
    }

    /**
     * 发送图片
     * @throws Exception
     */
    @Test
    void sendImgMail() throws Exception{
        String to = "846272692@qq.com";
        String subject = "springboot发送图片邮件";
        String content = "<h2>第一封springboot图片邮件</h2>" +
                "<br/> <img src=\"cid:img01\" />";
        String imgPath = "birthday.jpg";
        Map<String,String> imgMap = new HashMap<>();
        imgMap.put("img01",imgPath);
        mailService.sendImgMail(to,subject,content,imgMap);
    }
    /**
     * 发送附件邮件
     */
    @Test
    void sendAttachmentMail() throws Exception {
        String to = "846272692@qq.com";
        String subject = "SpringBoot 发送附件邮件";
        String content = "<h3>第一封 SpringBoot 附件邮件</h3>";
        String filePath = "D:\\spring-boot-review\\spring-boot-task-schedule\\src\\main\\java\\com\\soft1851\\springboot\\task\\schedule\\task\\AutoTask.java";
        mailService.sendAttachmentMail(to, subject, content, filePath, filePath);
    }
    /**
     * 发送模板
     */
    @Test
    public void sendTemplateMail() throws Exception {
        //创建邮件字段
        Context context = new Context();
        context.setVariable("name","祝您生日快乐");
        context.setVariable("realName","您的好友");
        // 将字段加载到页面模板中
        String emailContent = templateEngine.process("Card", context);
        mailService.sendHtmlMail("846272692@qq.com","主题：模板邮件[生日快乐!]",emailContent);
    }

    @Test
    public void sendAsyncTaskMail() throws  Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject("通知");
        mimeMessageHelper.setText("！！！");
        mimeMessageHelper.setTo("846272692@qq.com");
        mimeMessageHelper.setFrom("846272692@qq.com");
        mimeMessageHelper.addAttachment("AutoTask.java",new File("D:\\spring-boot-review\\spring-boot-task-schedule\\src\\main\\java\\com\\soft1851\\springboot\\task\\schedule\\task\\AutoTask.java"));
        javaMailSender.send(mimeMessage);



    }




}