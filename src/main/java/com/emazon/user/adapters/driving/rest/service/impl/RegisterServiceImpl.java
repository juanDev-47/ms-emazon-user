package com.emazon.user.adapters.driving.rest.service.impl;

import com.emazon.user.adapters.driving.rest.dto.request.AuthenticationRequestDTO;
import com.emazon.user.adapters.driving.rest.dto.request.RegisterRequestDTO;
import com.emazon.user.adapters.driving.rest.mapper.request.UserRequestMapper;
import com.emazon.user.adapters.driving.rest.service.IRegisterService;
import com.emazon.user.domain.api.IAuthenticateServicePort;
import com.emazon.user.domain.dto.request.AuthorizationRequestDTO;
import com.emazon.user.domain.dto.response.AuthDtoResponse;
import com.emazon.user.domain.dto.response.AuthorizationResponseDTO;
import io.swagger.v3.core.util.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements IRegisterService {
    private final UserRequestMapper userRequestMapper;
    private final IAuthenticateServicePort userServicePort;

    @Override
    public AuthDtoResponse registerAuxBodega(RegisterRequestDTO registerRequestDTO) {
        return userServicePort.registerAuxBodega(userRequestMapper.toUser(registerRequestDTO));
    }

    @Override
    public AuthDtoResponse login(AuthenticationRequestDTO authenticationRequestDTO) {
        return userServicePort.login(userRequestMapper.toDto(authenticationRequestDTO));
    }

    @Override
    public AuthorizationResponseDTO authorize(String token) {
        return userServicePort.authorize(token);
    }


}
