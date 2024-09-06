package com.emazon.user.adapters.driving.rest.service;

import com.emazon.user.adapters.driving.rest.dto.request.RegisterRequestDTO;

public interface IUserService {
    String createUser(RegisterRequestDTO registerRequestDTO);
}
