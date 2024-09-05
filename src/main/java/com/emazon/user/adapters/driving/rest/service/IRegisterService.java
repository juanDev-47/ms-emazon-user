package com.emazon.user.adapters.driving.rest.service;

import com.emazon.user.adapters.driving.rest.dto.request.AuthenticationRequestDTO;
import com.emazon.user.adapters.driving.rest.dto.request.RegisterRequestDTO;
import com.emazon.user.domain.dto.request.AuthDtoRequest;
import com.emazon.user.domain.dto.response.AuthDtoResponse;


public interface IRegisterService {

    AuthDtoResponse registerAuxBodega(RegisterRequestDTO registerRequestDTO);

    AuthDtoResponse authenticate(AuthenticationRequestDTO authenticationRequestDTO);

}
