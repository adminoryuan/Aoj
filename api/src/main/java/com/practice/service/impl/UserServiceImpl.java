package com.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.practice.entity.User;
import com.practice.mapper.UserMapper;
import com.practice.pojo.Dto.Userdto;
import com.practice.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.practice.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    RedisUtils redisUtils;

    @Override
    public boolean Regist(User user) {
        User getUser = this.getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        if (null != getUser) {
            return false;
        } else {
//            String pwd = MD5Utils.string2MD5(user.getPassword());
//            User user1=new User();
//            user1.setPassword(user.getPassword());
//            user1.setEmail(user.getUsername());
            this.saveOrUpdate(user);
            return true;
        }
    }

    @Override
    public String Signel(User user) {

        User user1 = this.getOne(new QueryWrapper<User>().eq("username", user.getUsername()).eq("password", user.getPassword()));
        if (user1==null) return null;
        return CreteToken(user1);
    }

    /**
     * 生产一个token
     * @param u
     * @return
     */
    public String CreteToken(User u){
        String token= UUID.randomUUID().toString();

        Userdto userdto=new Userdto();
        userdto.setRole("ROLE_ADMIN");
        userdto.setUserName(u.getUsername());
        userdto.setPassword(u.getPassword());


        redisUtils.set(token,userdto,30*60*60); //设置30分钟过期


        return token;
    }
}
