package com.demo.rest.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String API_ALL_CATEGORY = "ALL_API";

	@Bean
	public Docket petApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName(API_ALL_CATEGORY).apiInfo(metadata()).select()
				// .apis(RequestHandlerSelectors.basePackage("com.demo.vcms.controller"))
				.paths(petstorePaths()).build();
	}

	private Predicate<String> petstorePaths() {
		return Predicates.or(regex("/v1/*"), regex("/v1/api.*"));
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("REST API documentation")
				.description("See https://github.com/vishalzanzrukia/rest-api-demo").version("1.0")
				.termsOfServiceUrl("https://github.com/vishalzanzrukia/rest-api-demo").license("MIT Licence (MIT)")
				.licenseUrl("https://github.com/vishalzanzrukia/rest-api-demo/blob/master/LICENSE")
				.contact(new Contact("Vishal Zanzrukia", "https://extjswithjava.blogspot.in",
						"vishalzanzrukia@gmail.com"))
				.build();
	}
}
