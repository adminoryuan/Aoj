package com.example.judgingserver.Server.Impl;

import com.example.judgingserver.Server.JudgeExec;
import com.example.judgingserver.dto.CompileDto;
import com.example.judgingserver.dto.ExecDto;
import org.springframework.stereotype.Component;

@Component
public class JudgeExecImpl implements JudgeExec {
    @Override
    public ExecDto Exec(CompileDto dto) {
        return null;
    }
}
