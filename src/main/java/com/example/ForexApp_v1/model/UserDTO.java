package com.example.ForexApp_v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;

    public UserDTO(){}

    public UserDTO(Long id, String name, String lastName, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserDTO(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
