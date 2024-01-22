package com.domain.user.user.dto;
import com.domain.user.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class UserDto {
    private final Long id;
    private final String name;
    private final String phone;
    private final Status status;
}
