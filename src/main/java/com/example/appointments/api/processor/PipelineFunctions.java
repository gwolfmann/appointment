package com.example.appointments.api.processor;

import com.example.appointments.api.models.bo.BussObject;
import com.example.appointments.api.models.from_db.DTOFromDB;
import com.example.appointments.api.models.to_present.DTOToPresent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;


public interface PipelineFunctions {

    public Mono<ServerRequest> validateRequest(ServerRequest request);

    public Mono<ServerRequest> validateParams(ServerRequest request);

    public <T> Mono<T> getDataFromDB(ServerRequest request);

    public <T, U> Mono<U> mapToBussObj(T dtoFromDB);

    public <T, U> Mono<U> mapToPresentation(T bussObject);

    public Mono<ServerResponse> handleErrorResponse(Throwable throwable);
}
/*
    {
        // Handle and log the error
        // You can customize the error response here
        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("An error occurred: " + throwable.getMessage());
    }

}
*/
