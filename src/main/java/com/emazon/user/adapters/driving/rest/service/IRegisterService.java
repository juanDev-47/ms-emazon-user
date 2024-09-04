package com.emazon.user.adapters.driving.rest.service;

import com.emazon.user.adapters.driving.rest.dto.request.RegisterRequestDTO;
import com.emazon.user.adapters.driving.rest.dto.response.AuthenticationResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IRegisterService {

    void register(RegisterRequestDTO registerRequestDTO);
}
