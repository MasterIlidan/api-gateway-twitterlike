package com.masterilidan.apigatewaytwitterlike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class ApiGatewayTwitterlikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayTwitterlikeApplication.class, args);
    }

}