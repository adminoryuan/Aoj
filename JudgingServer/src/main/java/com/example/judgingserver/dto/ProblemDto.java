package com.example.judgingserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 保存题和题的测试数据
 */
public class ProblemDto {

    @JsonProperty("Pid")
    int Pid;

    @JsonProperty("Code")
    String Code;

    @JsonProperty("CodeLuange")
    String CodeLuange;

    @JsonProperty("In")
    String In;

    @JsonProperty("Answer")
    String Answer;


    int Userid;

    long RunTime;

    long MemorySize;

}
