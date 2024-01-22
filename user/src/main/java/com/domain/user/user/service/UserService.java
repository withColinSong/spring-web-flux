package com.domain.user.user.service;

import com.domain.user.user.dto.UserDto;
import com.domain.user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserDto
                        .builder()
                        .id(user.getId())
                        .phone(user.getPhone())
                        .status(user.getStatus())
                        .build()
                ).toList();
    }
}
