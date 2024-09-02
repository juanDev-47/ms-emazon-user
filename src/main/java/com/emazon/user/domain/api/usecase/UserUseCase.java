package com.emazon.user.domain.api.usecase;

import com.emazon.user.adapters.driving.rest.dto.request.AuthenticationRequestDTO;
import com.emazon.user.domain.api.IUserServicePort;
import com.emazon.user.domain.model.User;

public class UserUseCase implements IUserServicePort {

    @Override
    public User registerUser(AuthenticationRequestDTO authenticationRequestDTO) {
        // validate business rules
        return null;
    }
}
