package com.example.judgingserver.Server;

import com.example.judgingserver.dto.FeginJudgeDto;
import com.example.judgingserver.dto.ExecDto;
import com.example.judgingserver.dto.ProblemDto;

/**
 * 执行代码
 */
public interface JudgeExec {

    FeginJudgeDto Exec(ProblemDto Prodto, FeginJudgeDto dto);

}
