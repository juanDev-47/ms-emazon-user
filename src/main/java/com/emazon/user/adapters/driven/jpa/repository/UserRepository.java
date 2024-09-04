package com.emazon.user.adapters.driven.jpa.repository;

import com.emazon.user.adapters.driven.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
