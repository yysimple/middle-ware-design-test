package com.simple.pagination.controller.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* 项目: pagination
*
* 功能描述: Swagger的基础配置
*
* @author: wuchengxing
* @create: 2022-05-24 16:23:38
**/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .enable(true)
        .select()
        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        .paths(PathSelectors.any())
        .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        .title("Swagger API")
        .description("UserInfo")
        .termsOfServiceUrl("localhost:xxx/swagger-ui.html")
        .version("1.0")
        .build();
    }
}