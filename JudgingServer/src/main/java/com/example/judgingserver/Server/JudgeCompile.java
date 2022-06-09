package com.example.judgingserver.Server;

import com.example.judgingserver.dto.FeginJudgeDto;
import com.example.judgingserver.dto.ProblemDto;
import org.springframework.beans.factory.parsing.Problem;

public interface JudgeCompile {

    FeginJudgeDto Compile(ProblemDto problem);
}
