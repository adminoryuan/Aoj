package com.practice.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author yh
 * @date 2022/6/12 下午4:19
 */
@Data
public class Tokendto {
    @JsonProperty("Userid")
    int Userid;

    @JsonProperty("ROLE")
    String  ROLE;

    @JsonProperty("UserName")
    String UserName;

    @JsonProperty("Name")
    String Name;
}
