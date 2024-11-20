package com.trimblecars.leaseManagement.bean;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;



@Configuration
@OpenAPIDefinition
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {
    	return new OpenAPI();
    }
    
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.trimblecars.*"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "Lease Management API",
//                "API documentation for Lease Management system.",
//                "1.0",
//                "Terms of service",
//                new Contact("Your Name", "www.example.com", "your.email@example.com"),
//                "License of API", "API license URL", Collections.emptyList());
//    }
}








































//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig  {
//
//    @Bean
//   public Docket api() {
////        return new Docket(DocumentationType.SWAGGER_2).select()
////                .apis(RequestHandlerSelectors.basePackage("com.trimblecars.leaseManagement"))
////                .paths(PathSelectors.regex("/.*"))
////                .build().apiInfo(apiInfoMetaData());
//    	return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.trimblecars.leaseManagement"))
//                .paths(PathSelectors.regex("/.*"))
//                .build()
//                .apiInfo(apiInfoMetaData());
//    }
//
//    private ApiInfo apiInfoMetaData() {
//
//        return new ApiInfoBuilder().title("TrimbleCars")
//                .description("API Endpoints")
//                .contact(new Contact("Deepan", "https://github.com/DeepanKumaran1993/TrimbleCars.git", "deepankumarang@outlook.com"))
//                .license("Apache 2.0")
//                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
//                .version("1.0.0")
//                .build();
//    }
//
//}
