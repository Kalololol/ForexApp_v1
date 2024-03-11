package com.example.ForexApp_v1.model;

import jakarta.validation.constraints.*;


public class UserDTO {
    private Long id;
    @NotBlank(message = "Pole imię nie może być puste")
    private String name;
    @NotBlank(message = "Pole nazwisko nie może być puste")
    private String lastName;
    @Email(message = "Niepoprawny format adresu email")
    private String email;
    @Size(min=6, max = 20, message = "Hasło powinno zawierac pomiedzy 6 a 20 slow")
    private String passwordHash;

    public UserDTO(){}

    public UserDTO(Long id, String name, String lastName, String email, String passwordHash) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public UserDTO(String name, String lastName, String email, String passwordHash) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
