package com.example.judgingserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class Tokendto {
   @JsonProperty("Userid")
   Integer Userid;


   @JsonProperty("Code")
   String Code;

   @JsonProperty("UserName")
   String UserName;

   @JsonProperty("Password")
   String Password;



}
