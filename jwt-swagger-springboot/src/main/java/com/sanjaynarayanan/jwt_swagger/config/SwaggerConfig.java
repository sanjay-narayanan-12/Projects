package com.sanjaynarayanan.jwt_swagger.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.sanjaynarayanan.jwt_swagger")).build().apiInfo(apiInfo())
				.useDefaultResponseMessages(false).securitySchemes(Collections.singletonList(apiKey()))
				.securityContexts(Collections.singletonList(securityContext())).genericModelSubstitutes(Optional.class);

	}

	@Bean
	public UiConfiguration uiConfiguration() {
		return UiConfigurationBuilder.builder().defaultModelsExpandDepth(-1).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Jwt with Swagger UI")
				.description("This is sample spring boot application using Jwt Swagger").version("1.0.0")
				.license("License").licenseUrl("").contact(new Contact(null, null, "sanjaynarayanan150@gmail.com"))
				.build();
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/api/v1.*"))
				.build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}

}