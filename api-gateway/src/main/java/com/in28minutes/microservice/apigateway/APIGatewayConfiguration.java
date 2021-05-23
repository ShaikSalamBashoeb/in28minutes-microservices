package com.in28minutes.microservice.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f ->f
								.addRequestHeader("MyHeader", "MyURI")
								.addRequestParameter("Param", "ParamValue"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**")
						.uri("lb://currency-exchange"))//http://localhost:8765/currency-exchange/from/USA/to/INR
				.route(p -> p.path("/currency-conversion/**")
						.uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-feign/**")//http://localhost:8765/currency-conversion-feign/from/USA/to/INR/quantity/20
						.uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-new/**")
							.filters(f -> f.rewritePath(
									"/currency-conversion-new/(?<segment>.*)", "/currency-conversion-feign/${segment}"))
							.uri("lb://currency-conversion"))
				.build();
				/*.route(p -> p.path("/get")
						.filters(f ->f
								.addRequestHeader("MyHeader", "MyURI")
								.addRequestParameter("Param", "ParamValue"))
						.uri("http://httpbin.org"80"));
				*/
	}
}
