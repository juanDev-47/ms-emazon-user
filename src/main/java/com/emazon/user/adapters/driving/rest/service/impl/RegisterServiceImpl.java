package com.emazon.user.adapters.driving.rest.service.impl;

import com.emazon.user.adapters.driving.rest.dto.request.RegisterRequestDTO;
import com.emazon.user.adapters.driving.rest.dto.response.AuthenticationResponseDTO;
import com.emazon.user.adapters.driving.rest.mapper.request.UserRequestMapper;
import com.emazon.user.adapters.driving.rest.service.IRegisterService;
import com.emazon.user.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements IRegisterService {
    private final UserRequestMapper userRequestMapper;
    private final IUserServicePort userServicePort;

    @Override
    public void register(RegisterRequestDTO registerRequestDTO) {
        userServicePort.registerUser(userRequestMapper.toUser(registerRequestDTO));
    }
}
