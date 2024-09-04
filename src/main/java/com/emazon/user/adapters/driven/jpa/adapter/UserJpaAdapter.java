package com.emazon.user.adapters.driven.jpa.adapter;

import com.emazon.user.adapters.driven.jpa.mapper.UserEntityMapper;
import com.emazon.user.adapters.driven.jpa.repository.UserRepository;
import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.UserRegisterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserJpaAdapter implements UserRegisterPort {
    private final UserEntityMapper userEntityMapper;
    private final UserRepository userRepository;
    @Override
    public void registerUser(User user) {
        // encrypt password

        userRepository.save(userEntityMapper.toEntity(user));
    }
}
