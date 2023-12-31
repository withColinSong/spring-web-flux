package com.domain.user.repository;

import com.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    <R> List<R> findBy(Class<R> type);
}
