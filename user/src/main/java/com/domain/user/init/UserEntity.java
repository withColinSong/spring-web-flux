package com.domain.user.init;

import com.domain.user.entity.User;
import com.domain.user.enums.STATUS;
import com.domain.user.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserEntity {

    private final UserRepository userRepository;

    @Transactional
    @PostConstruct
    public void userInit() {
        for (int i = 0; i < 100; i++) {
            userRepository.save(
                    User.builder()
                            .name("name" + i)
                            .phone("0100" + i + i)
                            .status(STATUS.ACTIVE)
                            .build()
            );
        }

    }

}
