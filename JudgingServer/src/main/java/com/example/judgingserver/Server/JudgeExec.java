package com.example.judgingserver.Server;

import com.example.judgingserver.dto.FeginJudgeDto;
import com.example.judgingserver.dto.ExecDto;

/**
 * 执行代码
 */
public interface JudgeExec {

    FeginJudgeDto Exec(FeginJudgeDto dto,String in);

}
