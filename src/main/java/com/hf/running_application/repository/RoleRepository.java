package com.hf.running_application.repository;

import com.hf.running_application.entities.Role;
import com.hf.running_application.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findRoleByUserName(String userName);
}
