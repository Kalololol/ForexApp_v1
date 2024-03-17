package com.example.ForexApp_v1.service;

import com.example.ForexApp_v1.logic.PasswordHashing;
import com.example.ForexApp_v1.model.User;
import com.example.ForexApp_v1.model.UserDTO;
import com.example.ForexApp_v1.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordHashing passwordHashing;
    public UserService(UserRepository userRepository, PasswordHashing passwordHashing) {
        this.userRepository = userRepository;
        this.passwordHashing = passwordHashing;
    }

    public boolean register(UserDTO userDTO){
        String passHash = passwordHashing.hidePassword(userDTO.getPasswordHash());
        User user = new User(userDTO.getName(), userDTO.getLastName(), userDTO.getEmail(), passHash);
        userRepository.createOrUpdate(user);
        return false;
    }

    public boolean logIn(String email, String password){
        try {
            User user = userRepository.findUserByEmail(email);
            String passwordInput = passwordHashing.hidePassword(password);
            return passwordHashing.checkPassword(passwordInput, user.getPasswordHash());
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
