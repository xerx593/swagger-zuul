package com.craigmgordon.gatewayservice;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import java.util.*;
@Controller
@EnableAutoConfiguration
@Primary
public class DocumentController implements SwaggerResourcesProvider{

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		resources.add(swaggerResource("product-service", "/prod/product/v2/api-docs", "1.0"));
		resources.add(swaggerResource("employee-service", "/emp/employee/v2/api-docs", "1.0"));
		
		return resources;
	}

	private SwaggerResource swaggerResource(final String name, final String location, final String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}
}
