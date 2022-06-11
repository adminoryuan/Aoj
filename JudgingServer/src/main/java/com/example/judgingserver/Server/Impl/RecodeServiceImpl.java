package com.example.judgingserver.Server.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.judgingserver.Server.RecodeService;
import com.example.judgingserver.entity.Recode;
import com.example.judgingserver.mapper.RecodeMapper;
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
public class RecodeServiceImpl extends ServiceImpl<RecodeMapper, Recode> implements RecodeService {

    @Override
    public boolean save(Recode entity) {
        return super.save(entity);
    }
}
