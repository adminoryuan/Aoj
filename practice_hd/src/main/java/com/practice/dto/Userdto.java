package com.practice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.practice.entity.User;
import lombok.Data;
import lombok.NonNull;

import javax.print.DocFlavor;
import javax.validation.constraints.NotBlank;

@Data
public class Userdto{

   @JsonProperty("Code")
   @NotBlank(message = "验证码不为空")
   String Code;

   @JsonProperty("UserName")
   @NotBlank(message = "用户名不为空")
   String UserName;

   @JsonProperty("Password")
   @NotBlank(message = "密码不为空")
   String Password;

}
