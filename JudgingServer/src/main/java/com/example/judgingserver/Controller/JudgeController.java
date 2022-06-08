package com.example.judgingserver.Controller;

import com.example.judgingserver.Server.JudgeServer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Judge接口
 */
public class JudgeController {
    @Autowired
    JudgeServer server;
}
