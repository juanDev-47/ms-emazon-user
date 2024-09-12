package com.emazon.user.domain.dto.response;



public class AuthorizationResponseDTO {
    private final boolean authorized;
    private final String email;
    private final String role;
    private final Long id;

    public AuthorizationResponseDTO(Builder builder){
        this.authorized = builder.authorized;
        this.email = builder.email;
        this.role = builder.role;
        this.id = builder.id;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public Long getId(){return id;}

    public static class Builder{
        private boolean authorized;
        private String email;
        private String role;
        private Long id;

        public Builder(){}

        public AuthorizationResponseDTO.Builder authorized(boolean authorized){
            this.authorized = authorized;
            return this;
        }

        public AuthorizationResponseDTO.Builder email(String email){
            this.email = email;
            return this;
        }

        public AuthorizationResponseDTO.Builder role(String role){
            this.role = role;
            return this;
        }

        public AuthorizationResponseDTO.Builder id(Long id){
            this.id = id;
            return this;
        }


        public AuthorizationResponseDTO build(){
            return new AuthorizationResponseDTO(this);
        }

    }

    public static AuthorizationResponseDTO.Builder builder() {
        return new AuthorizationResponseDTO.Builder();
    }

}
