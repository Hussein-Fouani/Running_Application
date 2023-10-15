package com.hf.running_application.security;

import com.hf.running_application.entities.UserEntity;
import com.hf.running_application.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserDetails implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserFirstByUserName(username);
        if (user != null) {
            User user1 = new User(
            user.getEmail(),
            user.getPassword(),
            user.getRoles().stream().map((role)-> new SimpleGrantedAuthority(role.getUserName())).collect(Collectors.toList()));
            return user1;
        }else{
            throw new UsernameNotFoundException("Invalid UserName and Password");
        }

    }
}
