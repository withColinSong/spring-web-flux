package com.domain.user.service;

import com.domain.user.dto.UserDto;
import com.domain.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> objectMapper.convertValue(user, UserDto.class))
                .collect(Collectors.toList());
    }
}
