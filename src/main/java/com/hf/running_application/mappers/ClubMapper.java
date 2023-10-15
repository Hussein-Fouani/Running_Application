package com.hf.running_application.mappers;

import com.hf.running_application.entities.Club;
import com.hf.running_application.model.ClubDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public class ClubMapper {
    private static ModelMapper modelMapper;

    public static Club mapToClub(ClubDTO DTO){
        return modelMapper.map(DTO,Club.class);
    }

    public static ClubDTO mapToClubDTO(Club club){
        return modelMapper.map(club,ClubDTO.class);
    }

}
