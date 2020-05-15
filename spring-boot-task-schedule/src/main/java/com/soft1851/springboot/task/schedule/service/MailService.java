package com.soft1851.springboot.task.schedule.service;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * @ClassName MailService
 * @Description TODO
 * @Author YangJinG
 * @Date 2020/5/15
 **/
public interface MailService  {
    /**
     * 发送简单的文本邮件
     */
    void sendSimpleTextMail(String to,String subject,String content);
    /**
     * 发送支持HTML解析的邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to,String subject,String content) throws MessagingException;

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param fileArr
     */
    void sendAttachmentMail(String to,String subject,String content,String... fileArr) throws MessagingException;

    /**
     * 发送带图片的邮件
     * @param to
     * @param subject
     * @param content
     * @param imgMap
     */
    void sendImgMail(String to, String subject, String content, Map<String,String> imgMap) throws MessagingException;
}