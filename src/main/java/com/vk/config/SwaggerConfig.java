package com.vk.config;

import org.springframework.context.annotation.*;

import springfox.documentation.builders.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



/**
 * Enabling swagger UI
 * 
 * http://localhost:8080/swagger-ui.html
 * 
 * 
 * @author v0k001r
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)

        .select()

        .apis(RequestHandlerSelectors.any())

        .paths(PathSelectors.any())

        .build();

  }
}
