package com.example.judgingserver.Server.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.judgingserver.Server.TestdataService;
import com.example.judgingserver.entity.Testdata;
import com.example.judgingserver.mapper.TestdataMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Vincent
 * @since 2022-06-10 20:55:13
 */
@Service
public class TestdataServiceImpl extends ServiceImpl<TestdataMapper, Testdata> implements TestdataService {

}
