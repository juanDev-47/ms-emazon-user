package com.emazon.user.adapters.driving.rest.dto.request;
import com.emazon.user.domain.utils.DomainConstants;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {

    @NotBlank(message = DomainConstants.FIELD_NAME_NULL_MESSAGE)
    private String name;

    @NotBlank(message = DomainConstants.FIELD_LASTNAME_NULL_MESSAGE)
    private String lastName;

    @NotNull(message = DomainConstants.FIELD_ID_DOCUMENT_NULL_MESSAGE)
    @Digits(integer = 20, fraction = 0,
            message = DomainConstants.FIELD_ID_DOCUMENT_JUST_NUMERIC_MESSAGE)
    private Long idDocument;

    @NotNull(message = DomainConstants.FIELD_PHONE_NULL_MESSAGE)
    @Pattern(regexp = "^\\+?[0-9]{10,13}$",
            message = DomainConstants.FIELD_PHONE_WELL_FORMATTED_MESSAGE)
    private Long cellPhone;

    @Past(message = DomainConstants.FIELD_NEW_BORN_NULL_MESSAGE)
    private Date bornDate;

    @NotBlank(message = DomainConstants.FIELD_EMAIL_NULL_MESSAGE)
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = DomainConstants.FIELD_EMAIL_VALID_FORMAT_MESSAGE)
    private String email;

    private String password;

}
