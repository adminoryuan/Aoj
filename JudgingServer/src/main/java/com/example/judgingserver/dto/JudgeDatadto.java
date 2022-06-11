package com.example.judgingserver.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class JudgeDatadto {
    Integer Memory;

    Integer Runtime;

    String[] input;

    String[] answer;
}
