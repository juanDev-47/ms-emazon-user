package com.emazon.user.domain.api.usecase;

import com.emazon.user.domain.api.IAuthenticateServicePort;
import com.emazon.user.domain.dto.request.AuthDtoRequest;
import com.emazon.user.domain.dto.response.AuthDtoResponse;
import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.AuthenticatePort;

public class AuthenticateUseCase implements IAuthenticateServicePort {
    private final AuthenticatePort authenticatePort;

    public AuthenticateUseCase(AuthenticatePort authenticatePort){
        this.authenticatePort = authenticatePort;
    }


    @Override
    public AuthDtoResponse registerAuxBodega(User user) {
        // validation, business rules
        return authenticatePort.registerAuxBodega(user);
    }

    @Override
    public AuthDtoResponse authenticate(AuthDtoRequest authDtoRequest) {
        return null;
    }
}
