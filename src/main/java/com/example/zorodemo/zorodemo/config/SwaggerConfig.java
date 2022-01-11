package com.example.zorodemo.zorodemo.config;

import io.swagger.annotations.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Zoro Demo")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/(pirate|damage)api.*"))
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Pirate_King_Crew_java_Spring_boot")
                .description("A sample project of spring boot & swagger")
                .license("Apache License 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .termsOfServiceUrl("https://github.com/masrur-ahmed")
                .version("2.0.0")
                .contact(new springfox.documentation.service.Contact("S. M. Masrur Ahmed","https://github.com/masrur-ahmed", "sm.masrur.ahmed@gmail.com"))
                .build();
    }

}
