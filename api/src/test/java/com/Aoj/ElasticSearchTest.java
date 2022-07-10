package com.Aoj;

import com.Aoj.entity.es.esSubjectEntity;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @author yh
 * @date 2022/7/10 下午1:03
 */
@SpringBootTest
public class ElasticSearchTest {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void AddSub() throws IOException {
        esSubjectEntity esSubjectEntity = new esSubjectEntity();
        esSubjectEntity.setSubName("计算1+2+3...+100");
        esSubjectEntity.setLevel(1);
        esSubjectEntity.setTag(new String[]{"逻辑计算"});
        esSubjectEntity.setPid(1);
        IndexRequest request = new IndexRequest("subject");
        request.source(JSON.toJSONString(esSubjectEntity), XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(request,RequestOptions.DEFAULT);

        System.out.println(response.toString());





    }
}
