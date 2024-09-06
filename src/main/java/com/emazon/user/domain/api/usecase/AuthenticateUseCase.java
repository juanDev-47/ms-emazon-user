package com.emazon.user.domain.api.usecase;

import com.emazon.user.domain.api.IAuthenticateServicePort;
import com.emazon.user.domain.api.IUserServicePort;
import com.emazon.user.domain.dto.request.AuthDtoRequest;
import com.emazon.user.domain.dto.response.AuthDtoResponse;
import com.emazon.user.domain.exception.EmailAlreadyExistException;
import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.AuthenticatePort;
import com.emazon.user.domain.spi.UserPort;
import com.emazon.user.domain.utils.DomainConstants;
import com.emazon.user.domain.validation.UserValidation;

import java.util.Objects;
import java.util.Optional;

public class AuthenticateUseCase implements IAuthenticateServicePort, IUserServicePort {
    private final AuthenticatePort authenticatePort;
    private final UserValidation userValidation;
    private final UserPort userPort;

    public AuthenticateUseCase(AuthenticatePort authenticatePort, UserValidation userValidation, UserPort userPort){
        this.authenticatePort = authenticatePort;
        this.userValidation = userValidation;
        this.userPort = userPort;
    }


    @Override
    public AuthDtoResponse registerAuxBodega(User user) {
        // validate not underage user
        userValidation.validateAdult(user.getBirthDate());
        if (existByEmail(user.getEmail())) throw new EmailAlreadyExistException(DomainConstants.FIELD_EMAIL_ALREADY_EXIST_MESSAGE);


        return authenticatePort.registerAuxBodega(user);
    }

    @Override
    public AuthDtoResponse authenticate(AuthDtoRequest authDtoRequest) {
        return null;
    }


    @Override
    public boolean existByEmail(String email) {
        return userPort.existByEmail(email);
    }
}
