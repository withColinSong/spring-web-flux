package com.aggregator.api.controller;

import com.aggregator.api.config.AuthHeader;
import com.aggregator.api.dto.CombinedResultDto;
import com.aggregator.api.dto.CouponDto;
import com.aggregator.api.model.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final WebClient webClient;
    private final AuthHeader authHeader;

    @GetMapping("/v1")
    public Flux<UserDto> findAll() {
        return webClient
                .get()
                .uri(authHeader.getHost() + "/api/v1/user")
                .header(authHeader.getKey(), authHeader.getPassword())
                .retrieve()
                .bodyToFlux(UserDto.class);
    }

    @GetMapping("/v2")
    public Flux<CouponDto> findAllCoupon() {
        return webClient
                .get()
                .uri(authHeader.getHost() + "/api/v1/coupon")
                .header(authHeader.getKey(), authHeader.getPassword())
                .retrieve()
                .bodyToFlux(CouponDto.class);
    }

    @GetMapping("/v3")
    public Flux<CombinedResultDto> fetchDataFromBothApis() {
        return Flux.zip(findAll(), findAllCoupon())
                .filter(objects -> objects.getT1().getId().equals(objects.getT2().getUserId()))
                .map(objects -> CombinedResultDto.builder()
                        .userId(objects.getT1().getId())
                        .type(objects.getT2().getType())
                        .status(objects.getT1().getStatus())
                        .build());
    }

}
