package com.hf.running_application.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class config {

    private UserDetails details;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((req)->{
                    req.requestMatchers("/login", "/register", "/clubs", "/register/**", "/css/**", "/js/**")
                            .permitAll()
                            .anyRequest()}).formLogin(form-> form.loginPage("/login")
                                    .defaultSuccessUrl("/clubs")
                                    .loginProcessingUrl("/login")
                                    .failureUrl("/login?error=true")
                                    .permitAll()).logout((logout)-> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());
        return security.build();
                }

    }

