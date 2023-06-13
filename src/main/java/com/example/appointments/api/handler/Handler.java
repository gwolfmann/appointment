package com.example.appointments.api.handler;

import com.example.appointments.api.processor.PipelineFunctions;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class Handler {
    public static Mono<ServerResponse> handleRequest(ServerRequest request) {
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

    public static Mono<ServerResponse> handlePing(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue("pong");
    }
}
