package com.emazon.user.configuration.bean;

import com.emazon.user.adapters.driven.jpa.adapter.UserJpaAdapter;
import com.emazon.user.adapters.driven.jpa.mapper.UserEntityMapper;
import com.emazon.user.adapters.driven.jpa.repository.UserRepository;
import com.emazon.user.adapters.driven.security.adapter.SecurityJwtAdapter;
import com.emazon.user.adapters.driven.security.jwt.JwtService;
import com.emazon.user.domain.api.IAuthenticateServicePort;
import com.emazon.user.domain.api.usecase.AuthenticateUseCase;
import com.emazon.user.domain.spi.AuthenticatePort;
import com.emazon.user.domain.spi.UserPort;
import com.emazon.user.domain.validation.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfigService {

    private final UserEntityMapper userEntityMapper;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    @Bean
    public AuthenticatePort userRegisterPort() {
        return new SecurityJwtAdapter(userEntityMapper, userRepository, jwtService, passwordEncoder);
    }

    @Bean
    public UserPort userPort() {
        return new UserJpaAdapter(userRepository);
    }

    @Bean
    public UserValidation userValidation(){
        return new UserValidation();
    }

    @Bean
    public IAuthenticateServicePort userServicePort(){
        return new AuthenticateUseCase(userRegisterPort(), userValidation(), userPort());
    }


}
