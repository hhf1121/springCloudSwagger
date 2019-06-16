package com.hhf.swaggerConfig;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2//开启swagger2
public class swaggerConfig {
	
	public Docket createRestApi(){
		Docket build = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
		.apis(RequestHandlerSelectors.basePackage("com.hhf.api")).paths(PathSelectors.any()).build();
		return build;
	}
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder().title("com.hhf").description("springCloud|swagger文档").termsOfServiceUrl("http://swagger.hhf.com").version("1.0.0").build();
	}

}
