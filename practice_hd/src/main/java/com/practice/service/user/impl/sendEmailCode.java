package com.practice.service.user.impl;

import com.practice.service.user.AbstSendverCode;
import com.practice.utils.EmailCompent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class sendEmailCode extends AbstSendverCode {

    @Autowired
    EmailCompent compent;
    @Override
    public String Send(String email) {
        System.out.println("发送邮件");
        String code="1234";
        compent.SendMailAsync(email,"这是一封注册邮件",code);
        return code;
    }
}
