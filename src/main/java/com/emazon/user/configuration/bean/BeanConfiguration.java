package com.emazon.user.configuration.bean;

import com.emazon.user.adapters.driven.jpa.adapter.UserJpaAdapter;
import com.emazon.user.adapters.driven.jpa.mapper.UserEntityMapper;
import com.emazon.user.adapters.driven.jpa.repository.UserRepository;
import com.emazon.user.domain.api.IUserServicePort;
import com.emazon.user.domain.api.usecase.UserUseCase;
import com.emazon.user.domain.spi.UserRegisterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final UserEntityMapper userEntityMapper;
    private final UserRepository userRepository;

    @Bean
    public UserRegisterPort userRegisterPort() {
        return new UserJpaAdapter(userEntityMapper, userRepository);
    }

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userRegisterPort());
    }


}
