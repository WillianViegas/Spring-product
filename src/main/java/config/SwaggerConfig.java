package config;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	
	@Bean
	 public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.willian.springproduct"))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(metaInfo());
    }

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Products API REST",
				"API REST of products solicitation",
				"1.0",
				"Terms of Service",
				new Contact("Willian", "https://github.com/WillianViegas", "willianwed98@gmail.com"),
				"Apache License 2.0",
				"http://www.apache.org/license.html", new ArrayList<>()
				);
		return apiInfo;
	}
}
