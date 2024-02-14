package com.aggregator.api.controller;

import com.aggregator.api.model.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/api/user/error")
public class UserErrorController {

    private final WebClient webClient;

    private UserErrorController(
            @Qualifier("clientHeaderFilter") WebClient webClient
    ) {
        this.webClient = webClient;
    }

    @GetMapping("/v1")
    public Flux<UserDto> findAll() {
        return webClient
                .get()
                .uri("/api/v1/user")
                .retrieve()
                .bodyToFlux(UserDto.class);
    }

    @GetMapping("/v3")
    public Flux<UserDto> connectionError() {
        return findAll()
                .onErrorReturn(new UserDto());
    }

    @GetMapping("/divide")
    public Flux<String> DividedZeroError() {
        return Flux.just(1, 2, 0)
                .log()
                .map(i -> "100 / " + i + " = " + (100 / i))
                .doOnError(o -> log.error("doOnError", o))
                .onErrorReturn("Divided by zero :(");
    }

}
