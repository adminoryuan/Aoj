package com.Aoj.service;

import com.Aoj.pojo.Vo.SubjectTagVo;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.search.SearchHits;

import java.util.Map;

/**
 * @author yh
 * @date 2022/7/10 下午12:42
 * es 搜索服务
 */

public interface SearchServer {


    /**
     * 添加一条题目信息
     * @param subjectTagVo
     * @return
     */
    boolean AddSubjectEs(SubjectTagVo subjectTagVo);

    boolean UpdateSubject(SubjectTagVo subjectTagVo);
    boolean DeleteSubjectEs(String pid);

     SearchHits SearchSub(Map<String,String> query);

}
