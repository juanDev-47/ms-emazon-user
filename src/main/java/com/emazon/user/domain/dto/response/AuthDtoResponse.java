package com.emazon.user.domain.dto.response;

public class AuthDtoResponse {
    private final String token;

    private AuthDtoResponse(Builder builder) {
        this.token = builder.token;
    }

    public String getToken() {
        return token;
    }


    public static class Builder {
        private String token;

        public Builder(){}

        public Builder token(String token){
            this.token = token;
            return this;
        }

        public AuthDtoResponse build(){
            return new AuthDtoResponse(this);
        }

    }
    public static Builder builder() {
        return new Builder();
    }
}
