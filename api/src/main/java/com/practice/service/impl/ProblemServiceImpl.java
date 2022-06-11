package com.practice.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.practice.entity.Problem;
import com.practice.entity.Testdata;
import com.practice.mapper.ProblemMapper;
import com.practice.pojo.Dto.JudgeDatadto;
import com.practice.pojo.Dto.ProblemDto;
import com.practice.pojo.Vo.ProUserVo;
import com.practice.service.ProblemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.practice.utils.RedisUtils;
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
    RedisUtils redisUtils;


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

        JudgeDatadto Judgedto=new JudgeDatadto();
        Judgedto.setMemory(dto.getSubMemroy());
        Judgedto.setRuntime(dto.getSubRuntime());
        Judgedto.setInput(dto.getInput());
        Judgedto.setAnswer(dto.getAnswer());

        redisUtils.hashPutOne("JudHash",dto.getId().toString(),Judgedto);
        redisUtils.hashPutOne("qutHash",dto.getId().toString(),dto);
        return true;
    }


    @Override
    public List<ProUserVo> getProAll(int page,int size) {
        System.out.println(page);
        System.out.println((page-1)*size);
        return this.getBaseMapper().getProAll((page-1)*size,size);
    }

    @Override
    public Problem getProblemOne(Integer id) {
        Object qutHash = redisUtils.hashGetOne("qutHash", id);
        if (qutHash!=null){
            Problem problem = JSONObject.parseObject(qutHash.toString(), Problem.class);
            return problem;
        }
        Problem problemOne = this.getProblemOne(id);

        redisUtils.hashPutOne("qutHash",id.toString(),problemOne);

        return problemOne;

    }

    /**
     * 减少数据库压力上缓存
     * @param dto
     * @return
     */
    @Override
    public boolean UpProblyem(ProblemDto dto) {
        if (!this.updateById(dto))return false;

        /**
         * 保证数据双写一致
         */
        redisUtils.hashDelete("qutHash",dto.getId().toString());
        redisUtils.hashDelete("JudHash",dto.getId().toString());

        JudgeDatadto Judgedto=new JudgeDatadto();
        Judgedto.setMemory(dto.getSubMemroy());
        Judgedto.setRuntime(dto.getSubRuntime());
        Judgedto.setInput(dto.getInput());
        Judgedto.setAnswer(dto.getAnswer());

        redisUtils.hashPutOne("JudHash",dto.getId().toString(),Judgedto);
        return true;
    }


}
