package com.Aoj.mapper;

import com.Aoj.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Aoj.pojo.Vo.UserOnLineVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Vincent
 * @since 2022-06-05 21:26:50
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM ojbase_User LIMIT #{page},#{size}")
    public List<UserOnLineVO> getall(@Param("page") int page,@Param("size") int size);
}
