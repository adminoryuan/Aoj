package com.practice.pojo.Req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.practice.entity.User;

import javax.servlet.annotation.WebFilter;
import javax.validation.constraints.NotBlank;


@WebFilter(filterName="FirstFilter",urlPatterns="/first")
public class LoginReq  {



   @JsonProperty("Code")
   @NotBlank(message = "验证码不为空")
   String Code;


   @JsonProperty("UserName")
   @NotBlank(message = "用户名不为空")
   String UserName;

   @JsonProperty("Password")
   @NotBlank(message = "密码不为空")
   String Password;



   public String getCode() {
      return Code;
   }

   public void setCode(String code) {
      Code = code;
   }

   public String getUserName() {
      return UserName;
   }


   public String getPassword() {
      return Password;
   }




}
