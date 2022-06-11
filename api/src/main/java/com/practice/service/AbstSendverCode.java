package com.practice.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public abstract class AbstSendverCode {

     /**
      * 返回发送的验证码
      * @param email
      * @return
      */
     public abstract String Send(String email);
}
