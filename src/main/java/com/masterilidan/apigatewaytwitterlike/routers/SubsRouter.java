package com.masterilidan.apigatewaytwitterlike.routers;

import com.masterilidan.apigatewaytwitterlike.config.UrlConfigurer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubsRouter {
    private final String subsServiceUrl;

    public SubsRouter(UrlConfigurer urlConfigurer) {
        subsServiceUrl = "http://" + urlConfigurer.getBaseAddrSubsService();
    }
    @Bean
    public RouteLocator subsServiceRoutes(RouteLocatorBuilder builder) {
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
