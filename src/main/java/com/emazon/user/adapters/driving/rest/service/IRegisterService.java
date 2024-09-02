package com.emazon.user.adapters.driving.rest.service;

import com.emazon.user.adapters.driving.rest.dto.request.RegisterRequestDTO;
import com.emazon.user.adapters.driving.rest.dto.response.AuthenticationResponseDTO;

public interface IRegisterService {

    AuthenticationResponseDTO register(RegisterRequestDTO registerRequestDTO);
}
