package com.hf.running_application.mappers;

import com.hf.running_application.entities.UserEntity;
import com.hf.running_application.model.RegistrationUserDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
public class UserMapper {
    private static ModelMapper modelMapper;

    public static UserEntity mapToUserEntity(RegistrationUserDTO registrationUserDTO){
      return   modelMapper.map(registrationUserDTO,UserEntity.class);
    }
    public static RegistrationUserDTO mapToUserEntity( UserEntity UserDTO){
        return   modelMapper.map(UserDTO,RegistrationUserDTO.class);
    }
}
