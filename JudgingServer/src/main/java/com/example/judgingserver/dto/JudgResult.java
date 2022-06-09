package com.example.judgingserver.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 返回一个结果给用户
 */
@Setter
@Getter
public class JudgResult {

    /**
     * 评测状态
     */
    String Statue;

    /**
     * 使用内存
     */
    long MemorySize;

    /**
     * 执行时长
     */
    long Exectime;

    /**
     * 输出
     */
    String stdout;

}
