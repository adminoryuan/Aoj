package com.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


public class SwaggerConfig {
    //配置了swagger的Docket的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }
    //配置swagger信息  apiinfo
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("可心的swagger文档")
                .description("我想认真读一本书")
                .version("v3.0")
                .termsOfServiceUrl("https://blog.csdn.net/weixin_58993861?type=blog")
                .contact("程序员")
                .build();

    }
}
