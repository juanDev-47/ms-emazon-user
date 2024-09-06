package com.emazon.user.domain.validation;


import com.emazon.user.domain.exception.UnderageUserException;
import com.emazon.user.domain.utils.DomainConstants;

import java.time.LocalDate;
import java.time.Period;

public class UserValidation {

    public UserValidation(){

    }

    public void validateAdult(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        if (age.getYears() < 18) {
            throw new UnderageUserException(DomainConstants.FIELD_BIRTHDATE_UNDERAGE_MESSAGE);
        }
    }


}
