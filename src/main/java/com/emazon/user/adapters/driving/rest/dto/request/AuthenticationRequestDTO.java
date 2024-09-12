package com.emazon.user.adapters.driving.rest.dto.request;

import com.emazon.user.domain.utils.DomainConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestDTO {

    @NotBlank(message = DomainConstants.FIELD_EMAIL_NULL_MESSAGE)
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = DomainConstants.FIELD_EMAIL_VALID_FORMAT_MESSAGE)
    private String email;

    @NotBlank(message = DomainConstants.FIELD_PASSWORD_MESSAGE)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$",
            message = DomainConstants.FIELD_PASSWORD_FORMAT_MESSAGE)
    @Size(min = 8, max = 20, message = DomainConstants.FIELD_PASSWORD_LENGTH_MESSAGE)
    private String password;
}
