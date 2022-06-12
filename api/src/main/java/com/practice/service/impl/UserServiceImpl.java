package com.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.practice.entity.User;
import com.practice.mapper.UserMapper;
import com.practice.pojo.Dto.Logindto;
import com.practice.pojo.Dto.Tokendto;
import com.practice.pojo.Vo.UserVO;
import com.practice.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.practice.utils.MD5Utils;
import com.practice.utils.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    TokenManager tokenManager;

    @Override
    public boolean Regist(Logindto user) {
        User getUser = this.getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        user.setROLE("ROLE_USER");
        if (null != getUser) {
            return false;
        } else {
            this.saveOrUpdate(user);
            return true;
        }
    }

    @Override
    public UserVO Signel(Logindto userDto) {

        User user1 = this.getOne(new QueryWrapper<User>().eq("username", userDto.getUsername()).eq("password", userDto.getPassword()));
        if (user1==null) return null;

        String token=tokenManager.getToken(user1);

        return new UserVO(user1.getName(),token);
    }


}
