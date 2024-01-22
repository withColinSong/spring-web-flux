package com.aggregator.api.dto;

import com.aggregator.api.model.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CouponDto {
    private Long id;
    private Long userId;
    private Type type;
}
