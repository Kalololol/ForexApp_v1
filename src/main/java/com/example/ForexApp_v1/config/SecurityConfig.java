package com.example.ForexApp_v1.config;

import com.example.ForexApp_v1.model.CustomUser;
import com.example.ForexApp_v1.service.CustomUserSecurityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final CustomUserSecurityService securityService;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public SecurityConfig(CustomUserSecurityService securityService) {
        this.securityService = securityService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/register")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin((form) -> form
                        .loginPage("/login")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error=true")
                        .permitAll()
                        .successHandler((request, response, authentication) -> {
                            // Pobierz szczegóły zalogowanego użytkownika
                            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                            Long userId = getIdFromUserDetails(userDetails);
                            request.setAttribute("userId", userId);
//request.getSession().setAttribute("userId", userId);
                            // Przekieruj na inną stronę po zalogowaniu
//                            response.sendRedirect("/dashboard");
                        }));


        //// W metodzie successHandler
        //request.getSession().setAttribute("userId", userId);
        //
        //// W innych metodach
        //Long userId = (Long) request.getSession().getAttribute("userId");

        return security.build();
    }

    private Long getIdFromUserDetails(UserDetails userDetails) {
        if (userDetails instanceof CustomUser) {
            return ((CustomUser) userDetails).getId();
        }
        return null;
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(securityService);
        dao.setPasswordEncoder(encoder);

        return dao;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider());
        return authenticationManagerBuilder.build();
    }

}