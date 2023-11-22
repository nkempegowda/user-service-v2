package com.jpmc.webflux.handler;

import com.jpmc.webflux.dto.UserDto;
import com.jpmc.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    @Autowired
    private UserService userService;


    public Mono<ServerResponse> getUserById(ServerRequest serverRequest) {

        Long userId = Long.valueOf(serverRequest.pathVariable("id"));
        return userService.getUser(userId).flatMap(
                userDto -> {
                    return ServerResponse.ok().bodyValue(userDto);
                }
        ).//switchIfEmpty(ServerResponse.notFound().build()).log();
         switchIfEmpty(ServerResponse.ok().bodyValue(new UserDto())).log();
    }


}
