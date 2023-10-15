package com.hf.running_application.services;

import com.hf.running_application.entities.UserEntity;
import com.hf.running_application.model.RegistrationUserDTO;

public interface UserService {
    void SaveUser(RegistrationUserDTO userDTO);

    UserEntity findUserByEmailAndUserName(String email);

    UserEntity findByUserName(String userName);
}
