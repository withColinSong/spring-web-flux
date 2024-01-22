package com.domain.user.entity;

import com.domain.user.enums.Status;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Table(schema = "USER")
@Entity
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Builder
    public User(String name, String phone, Status status) {
        this.name = name;
        this.phone = phone;
        this.status = status;
    }
}
