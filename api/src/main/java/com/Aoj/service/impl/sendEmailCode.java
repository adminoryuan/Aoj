package com.Aoj.service.impl;

import com.Aoj.service.AbstSendverCode;
import com.Aoj.utils.EmailCompent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class sendEmailCode extends AbstSendverCode {

    @Autowired
    EmailCompent compent;
    @Override
    public String Send(String email) {

        String code="1234";
        compent.SendMailAsync(email,"这是一封注册邮件",code);
        return code;
    }
}
