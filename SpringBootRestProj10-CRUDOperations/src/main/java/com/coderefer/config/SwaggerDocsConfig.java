package com.coderefer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {
    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2) // ui screen type
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.coderefer.controller"))
                .paths(PathSelectors.regex("/tourist.*"))//to specify request paths
                .build()
                .useDefaultResponseMessages(true)
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact("vamsi",
                "https://www.coderefer.com",
                "vamsi@coderefer.com");
        return new ApiInfo("Tourist API",
                "Gives info about tourist activities",
                "3.4.RELEASE", "https://www.hcl.com/license",
                contact,"MIT License",
                "https://mit.com", Collections.emptyList());
    }
}
