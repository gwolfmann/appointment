package com.example.appointments.api.router;

import com.example.appointments.api.handler.Handler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Configuration(proxyBeanMethods = false)
public class Routes {
    // Define the router function to handle requests
    @Bean
    public RouterFunction<ServerResponse> getRoutes() {
        return RouterFunctions.route()
                .GET("/endpoint", Handler::handleRequest)
                .GET("/ping", Handler::handlePing)
                .GET("/ping3", Handler::handlePing)
                .build();
    }
}
