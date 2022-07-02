package com.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.practice.entity.User;
import com.practice.mapper.UserMapper;
import com.practice.pojo.Req.LoginReq;
import com.practice.pojo.Req.RegistReq;

import com.practice.pojo.Vo.UserOnLineVO;
import com.practice.pojo.Vo.UserVO;
import com.practice.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.practice.utils.TokenManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Vincent
 * @since 2022-06-10 20:55:13
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    TokenManager tokenManager;

    @Override
    public boolean Regist(RegistReq user) {
        User getUser = this.getOne(new QueryWrapper<User>().eq("username", user.getUserName()));
        if (null != getUser) {
            return false;
        } else {
            User user1 = new User();
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            user1.setPhone(user.getPhone());
            user1.setROLE("ROLE_ADMIN");
            this.saveOrUpdate(getUser);
            return true;
        }
    }

    @Override
    public boolean offonline(Integer userid) {

        return tokenManager.OffOnline(userid.toString());
    }

    @Override
    public UserVO Signel(LoginReq userDto) {

        User user1 = this.getOne(new QueryWrapper<User>().eq("username", userDto.getUserName()).eq("password", userDto.getPassword()));
        if (user1==null) return null;

        String token=tokenManager.getToken(user1);

        return new UserVO(user1.getName(),token);
    }

    @Override
    public List<UserOnLineVO> getUserAll(int page, int size) {


        List<UserOnLineVO> getall = this.baseMapper.getall(size * (page - 1), size);


        tokenManager.getUserOnline(getall);
        return getall;
    }




}
