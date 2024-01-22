package com.domain.user.init;

import com.domain.user.entity.Coupon;
import com.domain.user.entity.Coupon.Type;
import com.domain.user.entity.User;
import com.domain.user.coupon.repository.CouponRepository;
import com.domain.user.enums.Status;
import com.domain.user.user.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserEntity {

    private final UserRepository userRepository;
    private final CouponRepository couponRepository;

    @Transactional
    @PostConstruct
    public void userInit() {
        User user;

        for (int i = 0; i < 100; i++) {
            user = userRepository.save(
                    User.builder()
                            .name("name" + i)
                            .phone("0100" + i + i)
                            .status(Status.ACTIVE)
                            .build()
            );

            couponRepository.save(
                    Coupon.builder()
                            .userId(user.getId())
                            .type(Type.DISCOUNT)
                            .build()
            );
        }
    }

}
