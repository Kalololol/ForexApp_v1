package com.example.ForexApp_v1.service;

import com.example.ForexApp_v1.model.CustomUser;
import com.example.ForexApp_v1.repositories.CustomUserDAO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserSecurityService implements UserDetailsService {
    private final CustomUserDAO customUserDAO = new CustomUserDAO();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = customUserDAO.findUserByEmail(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities("USER").build();
    }
}
