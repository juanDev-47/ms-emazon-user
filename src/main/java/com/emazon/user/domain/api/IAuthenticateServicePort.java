package com.emazon.user.domain.api;

import com.emazon.user.domain.dto.request.AuthDtoRequest;
import com.emazon.user.domain.dto.request.AuthorizationRequestDTO;
import com.emazon.user.domain.dto.response.AuthDtoResponse;
import com.emazon.user.domain.dto.response.AuthorizationResponseDTO;
import com.emazon.user.domain.model.User;

import java.util.Optional;

public interface IAuthenticateServicePort {
    AuthDtoResponse registerAuxBodega(User user);

    AuthDtoResponse login(AuthDtoRequest authDtoRequest);

    AuthorizationResponseDTO authorize(String token);

}
