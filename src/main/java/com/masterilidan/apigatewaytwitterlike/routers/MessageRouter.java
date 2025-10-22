package com.masterilidan.apigatewaytwitterlike.routers;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageRouter {
    @Bean
    public RouteLocator messageServiceRoutes(RouteLocatorBuilder builder) {
        String messageServiceUrl = "http://192.168.0.179:8081";

        RouteLocatorBuilder.Builder messages = builder.routes()
                .route(p -> {
                    String path = "/messages";
                    return p
                            .path(path)
                            .filters(f -> f.setPath(path))
                            .uri(messageServiceUrl);
                })
                .route(p -> {
                    String path = "/messages/user{id}";
                    return p
                            .path(path)
                            .filters(f -> f.setPath(path))
                            .uri(messageServiceUrl);
                })
                .route(p -> {
                    String path = "/messages/users/{userId}/page/{page}";
                    return p
                            .path(path)
                            .filters(f -> f.setPath(path))
                            .uri(messageServiceUrl);
                });
return messages.build();

    }
}
