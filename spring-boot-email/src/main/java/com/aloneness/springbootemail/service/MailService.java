package com.aloneness.springbootemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 *
 *
 * @author: tong
 * @create: 2020-04-06 18:42
 */
@Service
public class MailService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 使用SimpleMailMessage，设置发件人邮箱，收件人邮箱，主题和正文。
     * 普通文本发送
     *
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String to, String subject, String content){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        javaMailSender.send(simpleMailMessage);
    }

    /**
     * MimeMessages为复杂邮件模板，支持文本、附件、HTML、图片等。
     * 发送HTML内容
     *
     * @param to
     * @param subject
     * @param content
     * @throws MessagingException
     */
    public void sendHtmlMail(String to,String subject,String content) throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        // setText(context，true) 开启HTML内容， 默认为false
        mimeMessageHelper.setText(content,true);
        javaMailSender.send(mimeMessage);
    }

    /**
     * 发送附件
     *
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @throws MessagingException
     */
    public void sendAttachmentMail(String to,String subject,String content,String filePath) throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        // MimeMessageHelper(mimeMessage, true) 开启附件
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content,true);
        FileSystemResource fileSystemResource=new FileSystemResource(new File(filePath));
        String fileName=fileSystemResource.getFilename();
        mimeMessageHelper.addAttachment(fileName,fileSystemResource);
        javaMailSender.send(mimeMessage);
    }
}
