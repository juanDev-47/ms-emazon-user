package com.emazon.user.adapters.driven.security.adapter;

import com.emazon.user.adapters.driven.jpa.entity.UserEntity;
import com.emazon.user.adapters.driven.jpa.mapper.UserEntityMapper;
import com.emazon.user.adapters.driven.jpa.repository.UserRepository;
import com.emazon.user.adapters.driven.security.jwt.JwtService;
import com.emazon.user.domain.dto.request.AuthDtoRequest;
import com.emazon.user.domain.dto.response.AuthDtoResponse;
import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.AuthenticatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityJwtAdapter implements AuthenticatePort {

    private final UserEntityMapper userEntityMapper;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthDtoResponse registerAuxBodega(User user) {
        // encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // user to UserEntity
        UserEntity newUser = userEntityMapper.toEntity(user);

        userRepository.save(userEntityMapper.toEntity(user));

        return AuthDtoResponse.builder()
                .token(jwtService.getToken(newUser))
                .build();
    }

    @Override
    public AuthDtoResponse authenticate(AuthDtoRequest authDtoRequest) {
        return null;
    }
}
