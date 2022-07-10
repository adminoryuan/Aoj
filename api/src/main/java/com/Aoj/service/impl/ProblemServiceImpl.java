package com.Aoj.service.impl;

import com.Aoj.service.JudgedataService;

import com.Aoj.service.SearchServer;
import com.alibaba.fastjson.JSONObject;
import com.Aoj.entity.Problem;
import com.Aoj.entity.Judgedata;
import com.Aoj.mapper.ProblemMapper;
import com.Aoj.pojo.dto.JudgeDatadto;
import com.Aoj.pojo.dto.ProblemDto;
import com.Aoj.pojo.Vo.ProUserVo;
import com.Aoj.service.ProblemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Aoj.utils.RedisUtils;
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
    JudgedataService imp;



    @Autowired
    SearchServer _server;

    @Transactional
    @Override
    public boolean AddProblem(ProblemDto dto) {



        String[] answer = dto.getAnswer();
        String[] input = dto.getInput();
        if (answer.length!=input.length)return false;
        this.saveOrUpdate(dto);
        int index=0;

        while (index<answer.length){

            Judgedata judgedata =new Judgedata();
            judgedata.setInput(input[index]);
            judgedata.setAnswer(answer[index]);
            judgedata.setSid(dto.getId());
            imp.saveOrUpdate(judgedata);
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
