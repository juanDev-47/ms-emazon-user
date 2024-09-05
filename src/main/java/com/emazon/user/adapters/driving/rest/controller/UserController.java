package com.emazon.user.adapters.driving.rest.controller;

import com.emazon.user.adapters.driving.rest.dto.request.AuthenticationRequestDTO;
import com.emazon.user.domain.dto.response.AuthDtoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    @Operation(summary = "Create user into application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User logged", content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists", content = @Content),
            @ApiResponse(responseCode = "400", description = "User name is too long", content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<AuthDtoResponse> authenticate(@RequestBody AuthenticationRequestDTO authenticationRequestDTO){
//        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequestDTO));
        return null;
    }
}
