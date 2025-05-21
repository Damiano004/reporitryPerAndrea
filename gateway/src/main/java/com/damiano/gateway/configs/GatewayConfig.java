package com.damiano.gateway.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
            //catalog
            .route("catalog_root", r -> r
                .path("/catalog")
                .filters(f -> f.setPath("/api/products"))
                .uri("lb://catalog"))
                
            .route("catalog_all", r -> r
                .path("/catalog/**")
                .filters(f -> 
                    f.stripPrefix(1).prefixPath("/api/products"))
                .uri("lb://catalog"))

            //purchase
            .route("users_root", r -> r
                .path("/users")
                .filters(f -> f.setPath("/api/users"))
                .uri("lb://purchases"))

            .route("users_all",r -> r
                .path("/users/**")
                .filters(f ->
                    f.stripPrefix(1).prefixPath("/api/users"))
                .uri("lb://purchases"))

            .route("carts_root", r-> r
                .path("/carts")
                .filters(f -> f.setPath("/api/shoppingCarts"))
                .uri("lb://purchases"))

            .route("carts_all", r -> r
                .path("/carts/**")
                .filters(f ->
                    f.stripPrefix(1).prefixPath("/api/shoppingCarts"))
                .uri("lb://purchases"))

            //end
            .build();
    }
}
