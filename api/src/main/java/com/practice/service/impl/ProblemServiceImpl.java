package com.practice.service.impl;

import com.practice.entity.Problem;
import com.practice.entity.Testdata;
import com.practice.mapper.ProblemMapper;
import com.practice.pojo.Dto.ProblemDto;
import com.practice.pojo.Vo.ProUserVo;
import com.practice.service.ProblemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Vincent
 * @since 2022-06-10 20:54:03
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements ProblemService {

    @Autowired
    TestdataServiceImpl imp;

    @Transactional
    @Override
    public boolean AddProblem(ProblemDto dto) {


        String[] answer = dto.getAnswer();
        String[] input = dto.getInput();
        if (answer.length!=input.length)return false;
        this.saveOrUpdate(dto);
        int index=0;

        while (index<answer.length){

            Testdata testdata=new Testdata();
            testdata.setInput(input[index]);
            testdata.setAnswer(answer[index]);
            testdata.setSid(dto.getId());

            imp.saveOrUpdate(testdata);
            index++;
        }

        return false;
    }


    @Override
    public List<ProUserVo> getProAll(int page,int size) {
        System.out.println(page);
        System.out.println((page-1)*size);
        return this.getBaseMapper().getProAll((page-1)*size,size);
    }


}
