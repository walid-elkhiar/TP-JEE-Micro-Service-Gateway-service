package org.sid.ressources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	/*
	 * @Bean RouteLocator routeLocator (RouteLocatorBuilder builder) { return
	 * builder.routes()
	 * .route((r)->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
	 * .route((r)->r.path("/products/**").uri("lb://PRODUCT-SERVICE")) .build(); }
	 */
	@Bean
	//Dans la configuration dynamique il faut écrire le micro-service dans l'url:
	//http://localhost:8001/PRODUCT-SERVICE/products
	DiscoveryClientRouteDefinitionLocator 
	definitionLocator(ReactiveDiscoveryClient rdc,DiscoveryLocatorProperties dlp )
	{
		return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}
	
}
