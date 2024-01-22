package com.domain.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Table(name = "coupon")
@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Builder
    private Coupon(Long userId, Type type) {
        this.userId = userId;
        this.type = type;
    }

    public enum Type {
        CUSTOM, DISCOUNT
    }
}
