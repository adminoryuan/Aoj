package com.example.judgingserver.Server;

import com.example.judgingserver.dto.JudgResultDto;
import com.example.judgingserver.dto.ProblemDto;

public interface JudgeServer {
    JudgResultDto Judge(ProblemDto problemDto);
}
