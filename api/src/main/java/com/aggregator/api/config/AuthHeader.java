package com.aggregator.api.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AuthHeader {

    @Value("${server.secret.password}")
    private String password;

    @Value("${server.secret.key}")
    private String key;

    @Value("${server.host.api}")
    private String host;

}
