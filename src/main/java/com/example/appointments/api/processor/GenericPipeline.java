package com.example.appointments.api.processor;


import lombok.Builder;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Builder
public class GenericPipeline extends Pipeline<String,String,String> {

    protected final Function<ServerRequest, Mono<ServerRequest>> validateReq = noOp(ServerRequest);
    protected final Function<ServerRequest, Mono<ServerRequest>> validateBody;
    protected final Function<ServerRequest, Mono<RAW>> storageOp;
    protected final Function<RAW, Mono<BO>> boProcessor;
    protected final Function<BO, Mono<DTO>> presenter;

    public Function<ServerRequest, Mono<ServerRequest>> getValidateBody() {
        return validateBody;
    }

    public Mono<ServerRequest> validateRequest(ServerRequest request){
        return Mono.just(request);
    };

    public Mono<ServerRequest> validateParams(ServerRequest request){
        return Mono.just(request);
    };
    public Mono<String> getDataFromDB(ServerRequest request) {
        // Respond with "Pong" instead of retrieving data from the database
        return Mono.just("Pong");
    }

    public Mono<String> mapToBussObj(String dtoFromDB) {
        return Mono.just(dtoFromDB);
    }

    public Mono<String> mapToPresentation(String bussObject) {
        return Mono.just(bussObject);
    }
}
