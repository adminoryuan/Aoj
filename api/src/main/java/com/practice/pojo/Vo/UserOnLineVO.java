package com.practice.pojo.Vo;

/**
 * @author yh
 * @date 2022/6/14 下午5:46
 */

import com.practice.entity.User;
import lombok.Data;

/**
 * 返回用户信息以及用户是否在线
 */
@Data
public class UserOnLineVO extends User {
   boolean  IsOnLine;//用户是否在线

}
