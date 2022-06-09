package com.example.judgingserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProblemDto {

    int Pid;

    @JsonProperty("Code")
    String Code;

    @JsonProperty("CodeLuange")
    String CodeLuange;

}
