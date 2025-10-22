package com.masterilidan.apigatewaytwitterlike.routers;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubsRouter {
    @Bean
    public RouteLocator subsServiceRoutes(RouteLocatorBuilder builder) {
        String subsServiceUrl = "http://192.168.0.179:8082";
        RouteLocatorBuilder.Builder subs = builder.routes()
                //--------------------
                //subscription service
                //--------------------
                .route(p -> {
                    String path = "/subscription/follower{userId}";
                    return p
                            .path(path)
                            .filters(f -> f.setPath(path))
                            .uri(subsServiceUrl);
                })
                .route(p -> {
                    String path = "/subscription";
                    return p
                            .path(path)
                            .filters(f -> f.setPath(path))
                            .uri(subsServiceUrl);
                })
                .route(p -> {
                    String path = "/subscription/publisher{userId}";
                    return p
                            .path(path)
                            .filters(f -> f.setPath(path))
                            .uri(subsServiceUrl);
                });
        return subs.build();
    }
}
