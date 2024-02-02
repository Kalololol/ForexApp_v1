package com.example.ForexApp_v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
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
