package com.masterilidan.apigatewaytwitterlike.routers;

import com.masterilidan.apigatewaytwitterlike.config.UrlConfigurer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserRouter {

    private final String userServiceUrl;

    public UserRouter(UrlConfigurer urlConfigurer) {
        userServiceUrl = "http://" + urlConfigurer.getBaseAddrUserService();
    }

    @Bean
    public RouteLocator userServiceRouter(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder users = builder.routes()
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
                });
        return users.build();
    }
}
