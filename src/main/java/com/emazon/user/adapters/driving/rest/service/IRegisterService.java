package com.emazon.user.adapters.driving.rest.service;

import com.emazon.user.adapters.driving.rest.dto.request.AuthenticationRequestDTO;
import com.emazon.user.adapters.driving.rest.dto.request.RegisterRequestDTO;
import com.emazon.user.domain.dto.request.AuthDtoRequest;
import com.emazon.user.domain.dto.request.AuthorizationRequestDTO;
import com.emazon.user.domain.dto.response.AuthDtoResponse;
import com.emazon.user.domain.dto.response.AuthorizationResponseDTO;


public interface IRegisterService {

    AuthDtoResponse registerAuxBodega(RegisterRequestDTO registerRequestDTO);

    AuthDtoResponse login(AuthenticationRequestDTO authenticationRequestDTO);

    AuthorizationResponseDTO authorize(String token);

}
