package com.Aoj.service;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

/**
 * @author yh
 * @date 2022/6/12 下午8:13
 */
public interface RankService {

    Set<ZSetOperations.TypedTuple<Object>> getRank();
}
