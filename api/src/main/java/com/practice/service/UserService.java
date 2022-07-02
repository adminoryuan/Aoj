package com.practice.service;

import com.practice.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.practice.pojo.Req.LoginReq;
import com.practice.pojo.Req.RegistReq;

import com.practice.pojo.Vo.UserOnLineVO;
import com.practice.pojo.Vo.UserVO;

import java.util.List;

/**
 * <p>
 *  登录类
 * </p>
 *
 * @author Vincent
 * @since 2022-06-10 20:55:13
 */
public interface UserService extends IService<User> {

    UserVO Signel(LoginReq userdto);

    List<UserOnLineVO> getUserAll(int page, int size);

    boolean Regist(RegistReq userdto);

    boolean offonline(Integer id);
}
