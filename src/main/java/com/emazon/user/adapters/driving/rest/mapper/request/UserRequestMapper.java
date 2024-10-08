package com.emazon.user.adapters.driving.rest.mapper.request;

import com.emazon.user.adapters.driving.rest.dto.request.AuthenticationRequestDTO;
import com.emazon.user.adapters.driving.rest.dto.request.RegisterRequestDTO;
import com.emazon.user.domain.dto.request.AuthDtoRequest;
import com.emazon.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {
    User toUser(RegisterRequestDTO registerRequestDTO);

    AuthDtoRequest toDto(AuthenticationRequestDTO authenticationRequestDTO);
}
