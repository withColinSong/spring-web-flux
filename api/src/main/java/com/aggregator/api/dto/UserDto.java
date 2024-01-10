package com.aggregator.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String phone;
    private STATUS status;

    public enum STATUS {
        ACTIVE, INACTIVE
    }
}
