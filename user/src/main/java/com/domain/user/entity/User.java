package com.domain.user.entity;

import com.domain.user.enums.STATUS;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(schema = "USER")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;

    @Enumerated(value = EnumType.STRING)
    private STATUS status;

    @Builder
    public User(String name, String phone, STATUS status) {
        this.name = name;
        this.phone = phone;
        this.status = status;
    }
}
