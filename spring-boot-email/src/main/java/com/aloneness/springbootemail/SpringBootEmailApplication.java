package com.aloneness.springbootemail;

import com.aloneness.springbootemail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootEmailApplication implements CommandLineRunner {

    @Autowired
    private MailService mailService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmailApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        mailService.sendSimpleMail("logic9711@foxmail.com", "测试发送邮件", "hello spring boot mail");
        String content="<html>\n"+
                "<body>\n"+
                "<h3>hello world</h3>\n"+
                "</body>\n"+
                "</html>";
//        mailService.sendHtmlMail("logic9711@foxmail.com","测试邮件(包含HTML)",content);
        mailService.sendAttachmentMail("logic9711@foxmail.com","测试邮件(包含附件)",content,"C:\\Users\\huanshaolst\\Pictures\\Camera Roll\\318305.jpg");
    }
}
