package com.practice.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: MybatisPlusConfig
 * @description:
 * @author: sh.Liu
 * @date: 2022-03-04 14:55
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 老版本，目前已失效
     * @return
     */
    /**@Bean
    public PaginationInterceptor paginationInterceptor() {
    PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    return paginationInterceptor;
    }*/


    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor=new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}