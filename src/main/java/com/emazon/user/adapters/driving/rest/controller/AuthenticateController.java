package com.emazon.user.adapters.driving.rest.controller;

import com.emazon.user.adapters.driving.rest.dto.request.AuthenticationRequestDTO;
import com.emazon.user.adapters.driving.rest.dto.request.RegisterRequestDTO;
import com.emazon.user.adapters.driving.rest.service.IRegisterService;
import com.emazon.user.domain.dto.request.AuthorizationRequestDTO;
import com.emazon.user.domain.dto.response.AuthDtoResponse;
import com.emazon.user.domain.dto.response.AuthorizationResponseDTO;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.hibernate.query.sqm.tree.SqmNode.log;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticateController {

    private final IRegisterService registerService;


    @Operation(summary = "Login to application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User logged", content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists", content = @Content),
            @ApiResponse(responseCode = "400", description = "User name is too long", content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<AuthDtoResponse> authenticate(@Valid @RequestBody AuthenticationRequestDTO authenticationRequestDTO){
        return ResponseEntity.ok(registerService.login(authenticationRequestDTO));
    }

    @Operation(summary = "Add a new user to system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User added", content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists", content = @Content),
            @ApiResponse(responseCode = "400", description = "User name is too long", content = @Content)
    })
    @PostMapping(value = "registerAux")
    public ResponseEntity<AuthDtoResponse> registerAuxBodega(@Valid @RequestBody RegisterRequestDTO registerRequestDTO){
        return ResponseEntity.ok(registerService.registerAuxBodega(registerRequestDTO));
    }

    @PostMapping("/authorize")
    public ResponseEntity<AuthorizationResponseDTO> authorize(@RequestBody AuthorizationRequestDTO token){
        return ResponseEntity.accepted().body(registerService.authorize(token.getToken()));
    }

}


