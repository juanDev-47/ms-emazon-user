package com.emazon.user.domain.spi;

import com.emazon.user.domain.dto.request.AuthDtoRequest;
import com.emazon.user.domain.dto.response.AuthDtoResponse;
import com.emazon.user.domain.model.User;

public interface AuthenticatePort {

    AuthDtoResponse registerAuxBodega(User user);

    AuthDtoResponse authenticate(AuthDtoRequest authDtoRequest);
}
