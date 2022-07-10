package com.Aoj.service.impl;

import com.Aoj.service.RankService;
import com.Aoj.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author yh
 * @date 2022/6/12 下午8:14
 */
@Component
public class RankServiceImpl implements RankService {

    private final String RANKSETNAME="rankZset";
    @Autowired
    RedisUtils untity;
    @Override
    public Set<ZSetOperations.TypedTuple<Object>> getRank() {
        return untity.rangeWithScore(RANKSETNAME, 0, -1);

    }
}
