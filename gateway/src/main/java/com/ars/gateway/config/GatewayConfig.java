package com.ars.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class GatewayConfig {

    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user", r -> r.path("/users/**")
                        .filters(f -> f.filter(filter).stripPrefix(1))
//                        .uri("lb://user"))
                        .uri("http://user:9002"))

                .route("auth", r -> r.path("/auth/**")
                        .filters(f -> f.filter(filter).stripPrefix(1))
//                        .uri("lb://auth"))
                        .uri("http://auth:9004"))

                .route("prestador", r -> r.path("/prestador/**")
                        .filters(f -> f.filter(filter).stripPrefix(1))
//                        .uri("lb://prestador-servico"))
                        .uri("http://prestadorservico:8081"))

                .route("consumidor", r -> r.path("/consumidor/**")
                        .filters(f -> f.filter(filter).stripPrefix(1))
//                        .uri("lb://consumidor"))
                        .uri("http://consumidor:8082"))
                .build();
    }

}
