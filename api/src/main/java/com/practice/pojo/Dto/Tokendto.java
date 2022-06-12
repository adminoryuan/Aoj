package com.practice.pojo.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yh
 * @date 2022/6/12 下午4:19
 */
@Data
public class Tokendto {
    @JsonProperty("Userid")
    int Userid;


    @JsonProperty("Code")
    String Code;

    @JsonProperty("ROLE")
    String  ROLE;

    @JsonProperty("UserName")
    String UserName;

    @JsonProperty("Name")
    String Name;
}
