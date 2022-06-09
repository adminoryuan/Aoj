package com.example.judgingserver.Controller;

import com.example.judgingserver.Server.JudgeServer;
import com.example.judgingserver.dto.JudgResult;
import com.example.judgingserver.dto.ProblemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Judge接口
 */
@RestController
public class JudgeController {
    @Autowired
    JudgeServer server;


    @PostMapping("/QJudge")
    public JudgResult Judge(@RequestBody ProblemDto problem){
        return server.Judge(problem);
    }

    @PostMapping("/Judge")
    public JudgResult Judge1(){
        return new JudgResult();
    }
}
