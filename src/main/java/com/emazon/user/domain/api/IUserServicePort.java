package com.emazon.user.domain.api;

import com.emazon.user.adapters.driving.rest.dto.request.AuthenticationRequestDTO;
import com.emazon.user.domain.model.User;

public interface IUserServicePort {
    User registerUser(AuthenticationRequestDTO authenticationRequestDTO);
}
