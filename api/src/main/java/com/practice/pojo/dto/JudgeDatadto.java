package com.practice.pojo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 保存评测数据
 */
@Data
@Getter
@Setter
public class JudgeDatadto {
    Integer Memory;

    Integer Runtime;

    String[] input;

    String[] answer;
}
