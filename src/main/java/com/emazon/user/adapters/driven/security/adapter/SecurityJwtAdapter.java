package com.emazon.user.adapters.driven.security.adapter;

import com.emazon.user.adapters.driven.jpa.entity.UserEntity;
import com.emazon.user.adapters.driven.jpa.mapper.UserEntityMapper;
import com.emazon.user.adapters.driven.jpa.repository.UserRepository;
import com.emazon.user.adapters.driven.security.dto.JwtRequestDTO;
import com.emazon.user.adapters.driven.security.exceptions.InvalidTokenException;
import com.emazon.user.adapters.driven.security.jwt.JwtService;
import com.emazon.user.adapters.driven.security.mapper.JwtRequestMapper;
import com.emazon.user.domain.dto.request.AuthDtoRequest;
import com.emazon.user.domain.dto.request.AuthorizationRequestDTO;
import com.emazon.user.domain.dto.response.AuthDtoResponse;
import com.emazon.user.domain.dto.response.AuthorizationResponseDTO;
import com.emazon.user.domain.exception.EmailNotFoundException;
import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.AuthenticatePort;
import com.emazon.user.domain.utils.DomainConstants;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SecurityJwtAdapter implements AuthenticatePort {

    private final UserEntityMapper userEntityMapper;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtRequestMapper jwtRequestMapper;

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
    public AuthDtoResponse login(AuthDtoRequest authDtoRequest) {
        if (!authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDtoRequest.getEmail(), authDtoRequest.getPassword())).isAuthenticated()){
            throw new BadCredentialsException(DomainConstants.FIELD_PASSWORD_INCORRECT_MESSAGE);
        }

        UserEntity user = userRepository.findByEmail(authDtoRequest.getEmail()).orElseThrow();


        return AuthDtoResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

    @Override
    public AuthorizationResponseDTO authorize(String token) {
        try {
            String email = jwtService.getClaim(token, Claims::getSubject);

            UserEntity user = userRepository
                    .findByEmail(email)
                    .orElseThrow(() -> new EmailNotFoundException(email));

            boolean authorized = jwtService.isTokenValid(token, user);


            return AuthorizationResponseDTO.builder()
                    .authorized(authorized)
                    .role("ROLE_ADMIN").email(email).id(user.getId())
                    .build();

        } catch (InvalidTokenException e) {
            return AuthorizationResponseDTO.builder()
                    .authorized(false)
                    .role(null).email(null)
                    .build();

        }

    }
}
