package com.capston_design.fkiller.itoms.api_gateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> serviceDeskRoute() {
        return GatewayRouterFunctions.route("service_desk")
                .route(RequestPredicates.path("/api/incident"), HandlerFunctions.http("http://localhost:8080"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> serviceDeskSwaggerRoute() {
        return GatewayRouterFunctions.route("service_desk_swagger")
                .route(RequestPredicates.path("/aggregate/service-desk/v3/api-docs"), HandlerFunctions.http("http://localhost:8080"))
                .filter(setPath("/v3/api-docs"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> userServiceRoute() {
        return GatewayRouterFunctions.route("user_service")
                .route(RequestPredicates.path("/api/user"), HandlerFunctions.http("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> userServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("user_service_swagger")
                .route(RequestPredicates.path("/aggregate/user-service/v3/api-docs"), HandlerFunctions.http("http://localhost:8081"))
                .filter(setPath("/v3/api-docs"))
                .build();
    }


}
