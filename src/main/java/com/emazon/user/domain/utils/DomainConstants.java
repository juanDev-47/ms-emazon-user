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
    public static final String FIELD_ID_DOCUMENT_NULL_MESSAGE = "Field 'Id Document' cannot be null or empty";
    public static final String FIELD_PHONE_NULL_MESSAGE = "Field 'cell phone' cannot be null or empty";
    public static final String FIELD_NEW_BORN_NULL_MESSAGE = "Field 'new born' need to be a past date";
    public static final String FIELD_ID_DOCUMENT_JUST_NUMERIC_MESSAGE = "Field 'ID Document' must to be just numeric";
    public static final String FIELD_PHONE_WELL_FORMATTED_MESSAGE = "cellphone number need to have at least 10 digits and can have the plus symbol";

}
