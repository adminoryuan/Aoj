package com.example.judgingserver.Server.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.judgingserver.Server.ProblemService;
import com.example.judgingserver.dto.ProblemDto;
import com.example.judgingserver.entity.Problem;
import com.example.judgingserver.entity.Testdata;
import com.example.judgingserver.mapper.ProblemMapper;
import com.example.judgingserver.untity.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Vincent
 * @since 2022-06-10 20:54:03
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements ProblemService {

    @Autowired
    RedisUtils redisUtils;


    @Autowired
    TestdataServiceImpl imp;





}
