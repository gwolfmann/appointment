package com.example.appointments.api.handler;

import org.springframework.http.HttpStatus;
        import org.springframework.http.MediaType;
        import org.springframework.web.reactive.function.server.*;
        import reactor.core.publisher.Flux;
        import reactor.core.publisher.Mono;

public class UserHandler extends Handler {

    public Mono<ServerResponse> handleRequest(ServerRequest request) {
        Mono<ServerRequest> requestMono = Mono.just(request);

        return requestMono
                .flatMap(PipelineFunctions::validateRequest)
                .flatMap(PipelineFunctions::validateParams)
                .flatMap(PipelineFunctions::getDataFromDB)
                .flatMap(PipelineFunctions::mapToBussObj)
                .flatMap(PipelineFunctions::mapToPresentation)
                .flatMap(dtoToPresent ->
                        ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(dtoToPresent))
                .onErrorResume(throwable -> PipelineFunctions.handleErrorResponse(throwable));
    }

    public Mono<ServerResponse> handlePing(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue("pong");
    }

    public Mono<ServerResponse> handleGetUsers(ServerRequest request) {
        // Simulated user data
        Flux<User> users = Flux.just(
                new User("John Doe", 25),
                new User("Jane Smith", 30),
                new User("Mike Johnson", 40)
        );

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users, User.class);
    }

    // Other user-related handler methods
}
