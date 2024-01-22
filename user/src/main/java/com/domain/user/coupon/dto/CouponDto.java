package com.domain.user.coupon.dto;

import com.domain.user.entity.Coupon;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CouponDto {
    private final Long id;
    private final Long userId;
    private final Coupon.Type type;
}
