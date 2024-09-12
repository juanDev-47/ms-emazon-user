package com.emazon.user.domain.utils;

public class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public enum Field {
        NAME,
        LASTNAME,
        EMAIL,
        CELLPHONE,
        PASSWORD,
        IDDOCUMENT

    }

    // NULL Messages
    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' cannot be null";
    public static final String FIELD_LASTNAME_NULL_MESSAGE = "Field 'lastName' cannot be null";
    public static final String FIELD_EMAIL_NULL_MESSAGE = "Field 'email' cannot be null";
    public static final String FIELD_EMAIL_VALID_FORMAT_MESSAGE = "Field 'email' need be well formatted";
    public static final String FIELD_EMAIL_ALREADY_EXIST_MESSAGE = "Field 'email' already exist, need a new one";
    public static final String FIELD_EMAIL_NOT_FOUND_MESSAGE = "Field 'email' cant found, please check it again";
    public static final String FIELD_ID_DOCUMENT_NULL_MESSAGE = "Field 'Id Document' cannot be null or empty";
    public static final String FIELD_PHONE_NULL_MESSAGE = "Field 'cell phone' cannot be null or empty";
    public static final String FIELD_PASSWORD_MESSAGE = "Field 'password' cannot be null or empty";
    public static final String FIELD_PASSWORD_LENGTH_MESSAGE = "Field 'password' cant be less than 8 characters and dont be more than 20 characters";
    public static final String FIELD_PASSWORD_INCORRECT_MESSAGE = "Field 'password' is incorrect, try again";
    public static final String ACCESS_DENIED_MESSAGE = "Your profile dont have access to this resource";
    public static final String FIELD_TOKEN_NULL_MESSAGE = "Token is empty please validate.";
    public static final String INVALID_TOKEN_MESSAGE = "Authorization token is invalid";
    public static final String FIELD_PASSWORD_FORMAT_MESSAGE = "Field 'password' must be at least 8 characters, including a capital letter, a number, and a special character.";
    public static final String FIELD_NEW_BORN_NULL_MESSAGE = "Field 'new born' need to be a past date";
    public static final String FIELD_BIRTHDATE_UNDERAGE_MESSAGE = "Field 'birthdate' must be older than 18 years for get register.";
    public static final String FIELD_ID_DOCUMENT_JUST_NUMERIC_MESSAGE = "Field 'ID Document' must to be just numeric";
    public static final String FIELD_PHONE_WELL_FORMATTED_MESSAGE = "cellphone number need to have at least 10 digits and can have the plus symbol";

}
