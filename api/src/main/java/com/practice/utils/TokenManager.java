package com.practice.utils;

import com.practice.entity.User;
import com.practice.pojo.Dto.Tokendto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author yh
 * @date 2022/6/12 下午5:37
 */
@Component
public class TokenManager {
    @Autowired
    RedisUtils redisUtils;

    private final String TokenHashName="tokenMap"; //保存token 和用户名的对应关系

    public String getToken(User user){
        Object tokens=IsExitToken(user.getId().toString());
        String Newtoken;
        if (tokens!=null){
            Object o = redisUtils.get(tokens.toString());
            if (o==null){
                redisUtils.hashDelete(TokenHashName,user.getId().toString());
                Newtoken=CreateToken(user);
            }else {
                Newtoken=tokens.toString();
            }
        }else{
            Newtoken=CreateToken(user);
        }
        return Newtoken;
    }

    private String CreateToken(User u){
        String s = MD5Utils.string2MD5(UUID.randomUUID().toString());
        Tokendto tokendto=new Tokendto();
        tokendto.setUserid(u.getId());
        tokendto.setROLE(u.getROLE());
        tokendto.setUserName(u.getUsername());
        tokendto.setName(u.getName());

        redisUtils.set(s,tokendto,30*60*60);
        redisUtils.hashPutOne(TokenHashName,u.getId().toString(),s);

        return s;
    }

    /**
     * 判断token 是否存在 存在直接返回 否则返回null
     * @param userid
     * @return
     */
    private Object IsExitToken(String userid){
        return redisUtils.hashGetOne(TokenHashName, userid);
    }

}
