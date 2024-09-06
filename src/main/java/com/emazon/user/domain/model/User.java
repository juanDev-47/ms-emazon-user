package com.emazon.user.domain.model;

import java.time.LocalDate;
import java.util.Date;

public class User {

    private String name;
    private String lastName;
    private Long idDocument;
    private String cellPhone;
    private LocalDate birthDate;
    private String email;
    private String password;
    private Role role;

    public User(String name, String lastName, Long idDocument, String cellPhone, LocalDate birthDate,String email, String password, Role role) {
        this.name = name;
        this.lastName = lastName;
        this.idDocument = idDocument;
        this.cellPhone = cellPhone;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Long idDocument) {
        this.idDocument = idDocument;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
