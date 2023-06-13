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


public class PipelineFunctions {

    public  Mono<ServerRequest> validateRequest(ServerRequest request) {
        // Perform request validation logic
        return Mono.just(request);
    }

    public Mono<ServerRequest> validateParams(ServerRequest request) {
        // Perform parameter validation logic
        return Mono.just(request);
    }

    public Mono<DTOFromDB> getDataFromDB(ServerRequest request) {
        // Retrieve data from the database
        DTOFromDB data = new DTOFromDB(); // Replace with actual data retrieval
        return Mono.just(data);
    }

    public Mono<BussObject> mapToBussObj(DTOFromDB dtoFromDB) {
        // Perform mapping logic from DTOFromDB to BussObject
        BussObject bussObject = new BussObject(); // Replace with actual mapping logic
        return Mono.just(bussObject);
    }

    public Mono<DTOToPresent> mapToPresentation(BussObject bussObject) {
        // Perform mapping logic from BussObject to DTOToPresent
        DTOToPresent dtoToPresent = new DTOToPresent(); // Replace with actual mapping logic
        return Mono.just(dtoToPresent);
    }

    public Mono<ServerResponse> handleErrorResponse(Throwable throwable) {
        // Handle and log the error
        // You can customize the error response here
        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("An error occurred: " + throwable.getMessage());
    }

}





