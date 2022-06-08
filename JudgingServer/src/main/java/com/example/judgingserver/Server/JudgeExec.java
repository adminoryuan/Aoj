package com.example.judgingserver.Server;

import com.example.judgingserver.dto.CompileDto;
import com.example.judgingserver.dto.ExecDto;

/**
 * 执行代码
 */
public interface JudgeExec {

    ExecDto Exec(CompileDto dto);

}
