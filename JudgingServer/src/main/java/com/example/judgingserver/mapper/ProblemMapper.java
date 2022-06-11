package com.example.judgingserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.judgingserver.dto.ProblemDto;
import com.example.judgingserver.entity.Problem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Vincent
 * @since 2022-06-10 20:54:03
 */
public interface ProblemMapper extends BaseMapper<Problem> {

    @Select("")
    ProblemDto getProblem(@Param("qid") int qid);
//
//    @Select("select A.Name,b.id,b.create_time,b.subDetailed,b.subLevel,b.tag from ojbase_User A inner join ojbase_problem b ON A.id=b.userid limit #{page},#{size}")
//    List<ProUserVo> getProAll(@Param("page") int page,@Param("size") int size);
}
