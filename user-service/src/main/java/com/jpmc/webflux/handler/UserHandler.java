package com.jpmc.webflux.handler;

import com.jpmc.webflux.dto.UserDto;
import com.jpmc.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    @Autowired
    private UserService userService;
    WebClient webClient;


    public Mono<ServerResponse> getUserById(ServerRequest serverRequest) {



        Long userId = Long.valueOf(serverRequest.pathVariable("id"));


        return userService.getUser(userId).flatMap(
                        userDto -> {
                            return ServerResponse.ok().bodyValue(userDto);
                        }
                ).switchIfEmpty(ServerResponse.notFound().build()).log();

        //switchIfEmpty(ServerResponse.ok().bodyValue(new UserDto())).log();
    }

    public Mono<ServerResponse> createUser(ServerRequest serverRequest) {

        Mono<UserDto> userDtoMono = serverRequest.bodyToMono(UserDto.class);
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        return  userDtoMono
                .flatMap(userService::createUser)
                .flatMap(userDto -> {
                    return  ServerResponse.status(HttpStatus.CREATED).bodyValue(userDto);
                })
                .switchIfEmpty(notFound);
    }

}
