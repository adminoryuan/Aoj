package com.example.judgingserver.Server;

import com.example.judgingserver.dto.JudgResult;
import com.example.judgingserver.dto.ProblemDto;

public interface JudgeServer {
    JudgResult Judge(ProblemDto problemDto);
}
