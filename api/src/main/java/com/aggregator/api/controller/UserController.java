package com.aggregator.api.controller;

import com.aggregator.api.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final WebClient webClient;
    private final String SECRET_KEY = "SECRET_KEY";
    private final String SECRET_PW = "01ASFDSA";

    @GetMapping("/v1")
    public Flux<UserDto> v1() {
        return webClient
                .get()
                .uri("http://localhost:8081/api/v1/user")
                .header(SECRET_KEY, SECRET_PW)
                .retrieve()
                .bodyToFlux(UserDto.class);
    }
}
