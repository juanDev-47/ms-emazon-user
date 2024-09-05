package com.emazon.user.adapters.driving.rest.service.impl;

import com.emazon.user.adapters.driving.rest.dto.request.AuthenticationRequestDTO;
import com.emazon.user.adapters.driving.rest.dto.request.RegisterRequestDTO;
import com.emazon.user.adapters.driving.rest.mapper.request.UserRequestMapper;
import com.emazon.user.adapters.driving.rest.service.IRegisterService;
import com.emazon.user.domain.api.IAuthenticateServicePort;
import com.emazon.user.domain.dto.response.AuthDtoResponse;
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
        System.out.println("from service controller:");
        Json.pretty(registerRequestDTO);
        return userServicePort.registerAuxBodega(userRequestMapper.toUser(registerRequestDTO));
    }

    @Override
    public AuthDtoResponse authenticate(AuthenticationRequestDTO authenticationRequestDTO) {
        return userServicePort.authenticate(userRequestMapper.toDto(authenticationRequestDTO));
    }


}
