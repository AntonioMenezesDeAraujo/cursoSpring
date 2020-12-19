package com.cursospringboot.bookstoragemanager.config;

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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private String BASE_PACKAGE = "com.cursospringboot.bookstoragemanager";
	private String title = "Bookstore Manager Course";
	private String DESCRIPTION = "Api de gerenciamento de livros profissional";
	private String USER = "Antonio Menezes de Araujo";
	private String URL = "http://www.github.com";
	private String EMAIL = "antoniomenezes20@gmail.com";

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any()).build().apiInfo(buildApiInfo());
	}

	private ApiInfo buildApiInfo() {
		return new ApiInfoBuilder()
				.title(title)
				.description(DESCRIPTION)
				.version("1.0.0")
				.contact(new Contact(USER, URL, EMAIL))
				.build();	
	}
}
