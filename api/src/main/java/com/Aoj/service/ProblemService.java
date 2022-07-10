package com.Aoj.service;

import com.Aoj.entity.Problem;
import com.Aoj.pojo.Vo.SubjectTagVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.Aoj.pojo.dto.ProblemDto;
import com.Aoj.pojo.Vo.ProUserVo;

import javax.security.auth.Subject;
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

    List<ProUserVo> getProAll(int page,int size);

    Problem getProblemOne(Integer id);

    boolean UpProblyem(ProblemDto Problem);

//select subName,subLevel,id,(select group_concat(tagName) from   ojbase_tag) as tags
//from ojbase_subject where id=1

    //List<SubjectTagVo> getSubjectTag(int pid);

}
