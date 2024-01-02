package com.domain.user.service;

import com.domain.user.dto.UserDto;
import com.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public List<UserDto> findAll() {
        return userRepository.findBy(UserDto.class);
    }
}
