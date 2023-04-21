package com.craigmgordon.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;

import springfox.documentation.PathProvider;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathProvider(new PathProvider() {
                    @Override
                    public String getApplicationBasePath() {
                        return "/unknownFunction1/"; // ??
                    }

                    @Override
                    public String getOperationPath(String s) { // this seems to have effect:
                        return s.replace("/products", contextPath() + "products");
                    }

                    @Override
                    public String getResourceListingPath(String s, String s1) {
                        return "/unknownFunction2/"; // ???
                    }
                })
                .select()
                .apis(RequestHandlerSelectors.basePackage(("com.craigmgordon.productservice")))
                .paths(PathSelectors.any())
                .build();
    }

    @Autowired
    ServerProperties serverProps;
    @Autowired
    WebMvcProperties webMvcProps;

    private String contextPath() {
        return serverProps.getServlet().getContextPath() + webMvcProps.getServlet().getPath();
    }
}
