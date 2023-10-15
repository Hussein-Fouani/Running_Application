package com.hf.running_application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationUserDTO {
        @jakarta.persistence.Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long Id;
        @NotEmpty(message = "Username Can't be Empty")
        private String  userName;
        @NotEmpty(message = "Email Can't be Empty")
        private String Email;
        @NotEmpty(message = "Password Can't be Empty")
        private String password;
}
