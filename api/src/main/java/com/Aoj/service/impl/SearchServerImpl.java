package com.Aoj.service.impl;

import com.Aoj.entity.es.esSubjectEntity;
import com.Aoj.pojo.Vo.SubjectTagVo;
import com.Aoj.service.SearchServer;
import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @author yh
 * @date 2022/7/10 下午12:42
 */
@Service
public class SearchServerImpl implements SearchServer {

    @Autowired
    RestHighLevelClient rest;


    @Override
    public boolean AddSubjectEs(SubjectTagVo subjectTagVo) {
        esSubjectEntity esSubjectEntity = new esSubjectEntity();
        esSubjectEntity.setSubName(subjectTagVo.getProName());
        esSubjectEntity.setLevel(subjectTagVo.getLevel());
        esSubjectEntity.setTag(subjectTagVo.getTags().split(","));
        esSubjectEntity.setPid(subjectTagVo.getPid());
        IndexRequest request = new IndexRequest("subject");
        request.source(JSON.toJSONString(esSubjectEntity), XContentType.JSON);
        request.id(""+subjectTagVo.getPid());
        try {
            IndexResponse response = rest.index(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateSubject(SubjectTagVo subjectTagVo) {
        esSubjectEntity  esSubjectEntity = new esSubjectEntity();
        esSubjectEntity.setSubName(subjectTagVo.getProName());
        esSubjectEntity.setLevel(subjectTagVo.getLevel());
        esSubjectEntity.setTag(subjectTagVo.getTags().split(","));
        esSubjectEntity.setPid(subjectTagVo.getPid());
        esSubjectEntity.setSubName(subjectTagVo.getProName());
        esSubjectEntity.setLevel(subjectTagVo.getLevel());
        esSubjectEntity.setTag(subjectTagVo.getTags().split(","));
        esSubjectEntity.setPid(subjectTagVo.getPid());

        IndexRequest indexRequest=new IndexRequest();
        indexRequest.id(""+subjectTagVo.getPid());
        indexRequest.source(JSON.toJSONString(esSubjectEntity),RequestOptions.DEFAULT);
        IndexResponse response = null;
        try {
            response = rest.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.isFragment();
    }

    @Override
    public boolean DeleteSubjectEs(String pid) {

        DeleteRequest request=new DeleteRequest();
        request.id(pid);
        DeleteResponse delete = null;
        try {
             delete = rest.delete(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return delete.isFragment();
    }


    @SneakyThrows
    @Override
    public SearchHits SearchSub(Map<String,String> query) {
        SearchRequest request = new SearchRequest("java");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        for (Map.Entry<String, String> entry : query.entrySet()) {

            QueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery(entry.getKey(),entry.getValue());

            builder.query(queryBuilder);
        }
        request.source(builder);
        SearchResponse responses = rest.search(request, RequestOptions.DEFAULT);
        System.out.println(responses.getHits());
        return responses.getHits();
    }
}
