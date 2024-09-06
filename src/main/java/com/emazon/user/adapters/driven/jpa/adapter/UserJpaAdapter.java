package com.emazon.user.adapters.driven.jpa.adapter;

import com.emazon.user.adapters.driven.jpa.entity.UserEntity;
import com.emazon.user.adapters.driven.jpa.mapper.UserEntityMapper;
import com.emazon.user.adapters.driven.jpa.repository.UserRepository;
import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserJpaAdapter implements UserPort {

    private final UserRepository userRepository;

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
