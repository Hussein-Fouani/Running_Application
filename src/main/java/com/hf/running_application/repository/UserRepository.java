package com.hf.running_application.repository;

import com.hf.running_application.entities.Role;
import com.hf.running_application.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserEntity,Long> {
    UserEntity findUserEntityByEmail(String email);
    UserEntity findUserEntityByUserName(String userName);

    UserEntity findUserFirstByUserName(String username);
}
