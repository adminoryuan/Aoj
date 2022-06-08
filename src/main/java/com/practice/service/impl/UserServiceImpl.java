package com.practice.service.impl;

import com.practice.entity.User;
import com.practice.mapper.UserMapper;
import com.practice.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Vincent
 * @since 2022-06-08 08:52:07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
