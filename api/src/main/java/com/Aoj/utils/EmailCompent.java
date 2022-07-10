package com.Aoj.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;

@Slf4j
@Component
public class EmailCompent {
    @Value("${spring.mail.username}")
    private String forEmail;

    @Value("${spring.mail.default-encoding}")
    private String encoding;

    @Resource
    private JavaMailSender javaMailSender;
    public String buildContent(String title) {
        //加载邮件html模板
        ClassPathResource resource = new ClassPathResource("Email.ftl");
        InputStream inputStream = null;
        BufferedReader fileReader = null;
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            inputStream = resource.getInputStream();
            fileReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = fileReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            System.out.println("失败！");
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //替换html模板中的参数
        return MessageFormat.format(buffer.toString(), title);
    }
    @Async
    public void SendMailAsync(String to,String subject,String conten){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(forEmail);
        message.setSubject(subject);

        message.setText(buildContent(conten));

        synchronized (javaMailSender){
            javaMailSender.send(message);
        }
    }
}
