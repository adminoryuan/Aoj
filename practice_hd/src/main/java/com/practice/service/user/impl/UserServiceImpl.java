package com.practice.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.practice.dto.Userdto;
import com.practice.entity.User;
import com.practice.mapper.UserMapper;
import com.practice.service.user.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.practice.utils.MD5Utils;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Function;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Vincent
 * @since 2022-06-05 21:27:28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean register(Userdto user) {
        User getUser = this.getOne(new QueryWrapper<User>().eq("username", user.getUserName()));
        if (null != getUser) {
            return false;
        } else {
            String pwd = MD5Utils.string2MD5(user.getPassword());
            User user1=new User();
            user1.setPassword(pwd);
            user1.setUsername(user.getUserName());
            this.saveOrUpdate(user1);
            return true;
        }
    }

    @Override
    public String Login(Userdto user) {
        String pwd1 = MD5Utils.string2MD5(user.getPassword());
        User user1 = this.getOne(new QueryWrapper<User>().eq("username", user.getUserName()).eq("password", pwd1));
        return user1 == null?null:CreteToken(user1);
    }

    /**
     * 生产一个token
     * @param u
     * @return
     */
    public String CreteToken(User u){
        String token= UUID.randomUUID().toString();

        return token;
    }
}
