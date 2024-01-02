package com.domain.user.dto;
import com.domain.user.enums.STATUS;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserDto {
    private final Long id;
    private final String name;
    private final String phone;
    private final STATUS status;
}
