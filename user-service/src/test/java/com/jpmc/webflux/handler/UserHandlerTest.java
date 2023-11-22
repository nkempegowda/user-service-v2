package com.jpmc.webflux.handler;

import com.jpmc.webflux.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import static com.jpmc.webflux.config.router.UserRouterConfig.GET_USER_URL;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserHandlerTest {

    public static final String BASE_URL = "http://localhost:8080";

    WebClient webClient;

    @BeforeEach
    void setUp(){
        webClient = WebClient.builder().baseUrl(BASE_URL)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create().wiretap(true)))
                .build();
    }

    @Autowired
    private WebTestClient webTestClient;


    @Test
    public void testGetUserById() throws InterruptedException{

        CountDownLatch countDownLatch = new CountDownLatch(1);

       Mono<UserDto> userDtoMono = webClient.get().uri(GET_USER_URL+"/"+1)
                .accept(APPLICATION_JSON)
                .retrieve().bodyToMono(UserDto.class);
        userDtoMono.subscribe(
                userDto -> {
                    System.out.println("*******************************************************************************************");
                    System.out.println(userDto.getName()+":"+userDto.getId()    );
                    System.out.println("*******************************************************************************************");
                    assertThat(userDto).isNotNull();
                   // assertThat(userDto.getName()).isNotNull();
                    countDownLatch.countDown();
                });

        countDownLatch.await(2000, TimeUnit.MILLISECONDS);
        assertThat(countDownLatch.getCount()).isEqualTo(0);

    }


}
