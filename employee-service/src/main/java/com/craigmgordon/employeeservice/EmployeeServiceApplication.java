package com.craigmgordon.employeeservice;

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
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathProvider(new PathProvider() {
                    @Override
                    public String getApplicationBasePath() {
                        return "/unknownFunction2/"; // ??
                    }

                    @Override
                    public String getOperationPath(String s) {
                        return s.replace("/employees", contextPath() + "employees");
                    }

                    @Override
                    public String getResourceListingPath(String s, String s1) {
                        return "/unknownFunction3/"; // ??
                    }
                })
                .select()
                .apis(RequestHandlerSelectors.basePackage(("com.craigmgordon.employeeservice")))
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
