package edu.ifpr.receitafacil.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    // http://localhost:8080/swagger-ui/index.html

    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
            "Exemplo API Swagger",
            "Este é um exemplo de documentação Swagger",
            "1.0.0",
            null,
            null,
            "API Licence",
            null,
            Collections.emptyList()
        );
    }

}
