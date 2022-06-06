package com.practice.service.user;

import com.practice.dto.Userdto;
import com.practice.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Vincent
 * @since 2022-06-05 21:27:28
 */
public interface UserService extends IService<User> {
    boolean register(Userdto user);

    /**
     * 返回token
     * @param user
     * @return
     */
    String Login(Userdto user);
}
