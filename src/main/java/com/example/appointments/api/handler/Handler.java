package com.example.appointments.api.handler;

import com.example.appointments.api.processor.PipelineFunctions;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public abstract class Handler {

    private final PipelineFunctions pipeline;

    protected Handler(PipelineFunctions pipeline) {
        this.pipeline = pipeline;
    }

    public Mono<ServerResponse> handleRequest(ServerRequest request) {
        Mono<ServerRequest> requestMono = Mono.just(request);

        return requestMono
                .flatMap(pipeline::validateRequest)
                .flatMap(pipeline::validateParams)
                .flatMap(pipeline::getDataFromDB)
                .flatMap(pipeline::mapToBussObj)
                .flatMap(pipeline::mapToPresentation)
                .flatMap(dtoToPresent ->
                        ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(dtoToPresent))
                .onErrorResume(pipeline::handleErrorResponse)
                .contextWrite(Context.of("key","value");
    }
}
