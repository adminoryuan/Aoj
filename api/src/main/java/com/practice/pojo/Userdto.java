package com.practice.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import java.util.Collection;

//@Data
public class Userdto implements UserDetails {

   @JsonProperty("Code")
   @NotBlank(message = "验证码不为空")
   String Code;

   @JsonProperty("UserName")
   @NotBlank(message = "用户名不为空")
   String UserName;

   @JsonProperty("Password")
   @NotBlank(message = "密码不为空")
   String Password;

   @Override
   public String toString() {
      return "Userdto{" +
              "Code='" + Code + '\'' +
              ", UserName='" + UserName + '\'' +
              ", Password='" + Password + '\'' +
              ", Role='" + Role + '\'' +
              '}';
   }

   public String getCode() {
      return Code;
   }

   public void setCode(String code) {
      Code = code;
   }

   public String getUserName() {
      return UserName;
   }

   public void setUserName(String userName) {
      UserName = userName;
   }

   public void setPassword(String password) {
      Password = password;
   }

   public String getRole() {
      return Role;
   }

   public void setRole(String role) {
      Role = role;
   }

   String Role;



   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return null;
   }

   public String getPassword() {
      return Password;
   }

   @Override
   public String getUsername() {
      return UserName;
   }



   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }


   @Override
   public boolean isEnabled() {
      return true;
   }
}
