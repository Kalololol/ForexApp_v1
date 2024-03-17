package com.example.ForexApp_v1.service;

import com.example.ForexApp_v1.model.CustomUser;
import com.example.ForexApp_v1.repositories.CustomUserDAO;
import org.springframework.stereotype.Service;

import javax.net.ssl.HandshakeCompletedEvent;
@Service
public class CustomUserService {
    Long userId = (Long) request.getSession().getAttribute("userId");
    private final CustomUserDAO customUserDAO = new CustomUserDAO();

    public CustomUser customUserLogIn(Long id){
        return customUserDAO.findById(id);
    }
}
