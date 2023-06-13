package com.example.appointments.api.processor;


import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

public class PingPipeline implements PipelineFunctions {

    @Override
    public Mono<String> getDataFromDB(ServerRequest request) {
        // Respond with "Pong" instead of retrieving data from the database
        return Mono.just("Pong");
    }

    @Override
    public Mono<String> mapToBussObj(String dtoFromDB) {
        return Mono.just(dtoFromDB);
    }

    @Override
    public Mono<String> mapToPresentation(String bussObject) {
        return Mono.just(bussObject);
    }
}
