package com.aggregator.api.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class WebClientConfiguration {

    private final AuthHeader authHeader;

    @Bean
    @Primary
    public WebClient client() {
        return WebClient.create();
    }

    private static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers().forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
            return Mono.just(clientRequest);
        });
    }

    @Bean
    public WebClient clientHeaderFilter() {
        return WebClient.builder()
                .baseUrl(authHeader.getHost())
                .filter((request, next) -> {
                    ClientRequest filtered = ClientRequest.from(request)
                            .header(authHeader.getKey(), authHeader.getPassword())
                            .build();
                    return next.exchange(filtered);
                })
                .filter(logRequest())
                .build();
    }
}
