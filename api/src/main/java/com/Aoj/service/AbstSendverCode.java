package com.Aoj.service;

import com.Aoj.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstSendverCode {


     private final int ValidTimeSpan=60;
     @Autowired
     private RedisUtils redisUtils;


      public String SendVerCode(String email){
          if (redisUtils.get(email)!=null){
               return null;
          }
           String send = Send(email);
           redisUtils.set(email,"",ValidTimeSpan);
          return send;
      }

     /**
      * 返回发送的验证码
      * @param email
      * @return
      */
     protected abstract String Send(String email);
}
