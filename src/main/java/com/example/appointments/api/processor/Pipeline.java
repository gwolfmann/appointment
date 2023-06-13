package com.example.appointments.api.processor;

import lombok.Builder;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Builder
public class Pipeline<RAW,BO,DTO> {

    public static <BO> Mono<BO> noOp(BO bo) {return Mono.just(bo);}

    protected final Function<ServerRequest, Mono<ServerRequest>> validateReq;
    protected final Function<ServerRequest, Mono<ServerRequest>> validateBody;
    protected final Function<ServerRequest, Mono<RAW>> storageOp;
    protected final Function<RAW, Mono<BO>> boProcessor;
    protected final Function<BO, Mono<DTO>> presenter;

}
