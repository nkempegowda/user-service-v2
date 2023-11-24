package com.jpmc.webflux.config.router;

import com.jpmc.webflux.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class UserRouterConfig {

    public static final String GET_USER_URL = "/api/users";

    public static final String GET_USER_BY_ID_URL = "/api/users/{id}";

    public static final String CREATE_USER_URL = "/api/users";

    @Bean
    public RouterFunction<ServerResponse> userRouter(UserHandler userHandler){
        return route().GET(GET_USER_BY_ID_URL, accept(APPLICATION_JSON),userHandler::getUserById)
                .POST(CREATE_USER_URL,userHandler::createUser)
                .build();
    }
}
