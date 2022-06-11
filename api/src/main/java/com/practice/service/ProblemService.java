package com.practice.service;

import com.practice.entity.Problem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.practice.pojo.Dto.ProblemDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Vincent
 * @since 2022-06-10 20:54:03
 */
public interface ProblemService extends IService<Problem> {

    boolean AddProblem(ProblemDto dto);


}
