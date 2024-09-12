package com.emazon.user.domain.dto.request;



public class AuthorizationRequestDTO {
    private String token;

    public AuthorizationRequestDTO(Builder builder) {
        this.token = builder.token;
    }

    public AuthorizationRequestDTO() {

    }


    public String getToken() {
        return token;
    }


    public static class Builder {
        private String token;

        public Builder(){}

        public AuthorizationRequestDTO.Builder token(String token){
            this.token = token;
            return this;
        }

        public AuthorizationRequestDTO build(){
            return new AuthorizationRequestDTO(this);
        }

    }
    public static AuthorizationRequestDTO.Builder builder() {
        return new AuthorizationRequestDTO.Builder();
    }
}

