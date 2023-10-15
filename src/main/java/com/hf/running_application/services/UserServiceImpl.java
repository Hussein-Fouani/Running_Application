package com.hf.running_application.services;

import com.hf.running_application.entities.Role;
import com.hf.running_application.entities.UserEntity;
import com.hf.running_application.model.RegistrationUserDTO;
import com.hf.running_application.repository.RoleRepository;
import com.hf.running_application.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.stereotype.Service;
import com.hf.running_application.mappers.UserMapper;

import java.util.Arrays;
import java.util.Collections;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public void SaveUser(RegistrationUserDTO userDTO) {
        UserEntity user = UserMapper.mapToUserEntity(userDTO);
        Role role = roleRepository.findRoleByUserName(user.getUserName());
        user.setRoles(Collections.singletonList(role));
        userRepository.save(user);
    }

    @Override
    public UserEntity findUserByEmailAndUserName(String email) {
        return userRepository.findUserEntityByEmail(email);
    }

    @Override
    public UserEntity findByUserName(String userName) {
        return userRepository.findUserEntityByUserName(userName);
    }
}
