package com.emazon.user.adapters.driven.security.mapper;

import com.emazon.user.adapters.driven.security.dto.JwtRequestDTO;
import com.emazon.user.adapters.driving.rest.dto.request.AuthenticationRequestDTO;
import com.emazon.user.domain.dto.request.AuthorizationRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JwtRequestMapper {

    JwtRequestDTO toJwtRequestDTO(AuthorizationRequestDTO authorizationRequestDTO);
}
