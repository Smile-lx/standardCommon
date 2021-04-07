package com.real.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Description: TODO
 * @Author Smile
 * @Date 2021/4/7
 * @Version V1.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) // 调用apiInfo方法
                .pathMapping("/") //配置访问路径
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.real.demo.api"))
                .paths(PathSelectors.any()) //匹配路径下的方法
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("")
                .contact(new Contact("gracie", "", "xxxxxxxxxx@qq.com"))
                .description("这是我的SwaggerUI生成的接口文档")
                .version("1.0.0.0")
                .build();
    }
}