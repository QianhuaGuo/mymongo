package com.qianhua.mongo.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Watermelon
 * @Date: 2021/4/7 11:31
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public Docket createRestApi(){
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfoBuilder().title("我的商城").
//                description("我的商城").build())
//                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any()).build();
//    }

    @Bean
    public Docket RestApi() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfoBuilder().title("运营管理系统").
                description("运营管理系统").build())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()/*.useDefaultResponseMessages(false).globalOperationParameters(setHeaderToken())*/;
    }

//    private List<Parameter> setHeaderToken() {
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("Authorization").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(tokenPar.build());
//        return pars;
//    }

}
