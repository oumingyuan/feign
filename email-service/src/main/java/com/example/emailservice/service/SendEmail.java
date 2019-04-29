package com.example.emailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class SendEmail {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送邮件
     *  @param title 邮件标题
     * @param url   收件人邮箱
     * @param email 邮件内容
     * @return  返回执行结果
     */
    @Async
    public CompletableFuture<Map> sendMail(String title, String url, String email) {
        Map<String, Object> map = new HashMap<>();
        if (isNullOrEmpty(title)) {
            map.put("code", "4001");
            map.put("msg", "请输入邮件标题");
            return CompletableFuture.completedFuture(map);
        }

        if (isNullOrEmpty(url)) {
            map.put("code", "4002");
            map.put("msg", "请输入收件人地址");
            return CompletableFuture.completedFuture(map);
        }

        if (isNullOrEmpty(email)) {
            map.put("code", "4003");
            map.put("msg", "请输入邮件内容");
            return CompletableFuture.completedFuture(map);
        }

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setSubject(title);
            message.setTo(url);
            message.setText(email);
            mailSender.send(message);

            map.put("code", "200");
            map.put("msg", "邮件发送成功");
            return CompletableFuture.completedFuture(map);
        } catch (Exception e) {
            throw new RuntimeException("发送邮件失败");
        }

    }

    private boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }
}
