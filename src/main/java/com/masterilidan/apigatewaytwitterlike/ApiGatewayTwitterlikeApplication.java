package com.masterilidan.apigatewaytwitterlike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(originPatterns = "http://192.168.0.*")
public class ApiGatewayTwitterlikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayTwitterlikeApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String subsServiceUrl = "http://192.168.0.179:8082";
        String messageServiceUrl = "http://192.168.0.179:8081";
        String userServiceUrl = "http://192.168.0.179:8080";
        return builder.routes()
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
                })
                //--------------------
                //message service
                //--------------------
                .route(p -> {
                    String path = "/messages";
                    return p
                            .path(path)
                            .filters(f -> f.setPath(path))
                            .uri(messageServiceUrl);
                })
                .route(p -> {
                        String path = "/messages/user/{id}";
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
                })
                //--------------------
                //user service
                //--------------------
                .route(p -> {
                    String path = "/register";
                    return p
                            .path(path)
                            .filters(f -> f.setPath(path))
                            .uri(userServiceUrl);
                })
                .route(p -> {
                    String path = "/user{id}";
                    return p
                            .path(path)
                            .filters(f -> f.setPath(path))
                            .uri(userServiceUrl);
                })
                .route(p -> {
                    String path = "/login";
                    return p
                            .path(path)
                            .filters(f -> f.setPath(path))
                            .uri(userServiceUrl);
                })
                .build();
    }
}