package com.practice.service;

import com.practice.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.practice.pojo.Dto.Logindto;
import com.practice.pojo.Vo.UserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Vincent
 * @since 2022-06-10 20:55:13
 */
public interface UserService extends IService<User> {

    UserVO Signel(Logindto userdto);


    boolean Regist(Logindto userdto);
}
