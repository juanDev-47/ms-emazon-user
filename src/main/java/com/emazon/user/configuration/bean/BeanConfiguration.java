package com.emazon.user.configuration.bean;

import com.emazon.user.adapters.driven.jpa.mapper.UserEntityMapper;
import com.emazon.user.adapters.driven.jpa.repository.UserRepository;
import com.emazon.user.adapters.driven.security.adapter.SecurityJwtAdapter;
import com.emazon.user.adapters.driven.security.jwt.JwtService;
import com.emazon.user.domain.api.IAuthenticateServicePort;
import com.emazon.user.domain.api.usecase.AuthenticateUseCase;
import com.emazon.user.domain.spi.AuthenticatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final UserEntityMapper userEntityMapper;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public AuthenticatePort userRegisterPort() {
        return new SecurityJwtAdapter(userEntityMapper, userRepository, jwtService, passwordEncoder);
    }

    @Bean
    public IAuthenticateServicePort userServicePort(){
        return new AuthenticateUseCase(userRegisterPort());
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService());
        authProvider.setPasswordEncoder(encoder());
        return  authProvider;
    }

    @Bean
    public UserDetailsService userDetailService() {
        return username -> (UserDetails) userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


}
