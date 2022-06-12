package com.example.judgingserver.Server;

//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "gooj",url = "120.48.61.75:5050")
public interface GoJudgServer {

    @RequestMapping(value = "/run",method = RequestMethod.POST)
    String run(String body);
}

