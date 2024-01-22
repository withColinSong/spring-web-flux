package com.domain.user.coupon.service;

import com.domain.user.coupon.dto.CouponDto;
import com.domain.user.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;

    public List<CouponDto> findAll() {
        return couponRepository.findAll()
                .stream()
                .map(coupon -> CouponDto
                        .builder()
                        .id(coupon.getId())
                        .type(coupon.getType())
                        .userId(coupon.getUserId())
                        .build()
                ).toList();
    }
}
