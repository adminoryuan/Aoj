package com.example.judgingserver.manager;

import com.alibaba.fastjson.JSONObject;
import com.example.judgingserver.untity.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
    *@author yh
    *@date 2022/6/12 下午7:55
*/

@Component
public class RankManager {

    @Autowired
    RedisUtils rutitl;

    private final String RANKSETNAME="rankZset";

    public void Rank(String Name){
        /**
         * 打完题加1
         */

        rutitl.addScore(RANKSETNAME,Name,1);
    }
}
