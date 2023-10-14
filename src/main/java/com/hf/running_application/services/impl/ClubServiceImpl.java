package com.hf.running_application.services.impl;

import com.hf.running_application.exceptions.ClubNotFoundException;
import com.hf.running_application.model.clubDTO;
import com.hf.running_application.entities.Club;
import com.hf.running_application.repository.clubrepository;
import com.hf.running_application.services.ClubService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private clubrepository repository ;
    private ModelMapper modelMapper ;

    public ClubServiceImpl(clubrepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<clubDTO> findAllClubs() {
        List<Club> getallclubs = repository.findAll();
        return getallclubs.stream().map(this::mapToClubDTO).collect(Collectors.toList());
    }

    @Override
    public Club save(Club club) {
        return repository.save(club);

    }

    @Override
    public  clubDTO  findClubById(long clubId) {
        Club clubs  = repository.findById(clubId).orElseThrow(()-> new ClubNotFoundException("Club Not Found",clubId));
        return mapToClubDTO(clubs);
    }

    @Override
    public void updateClub(clubDTO clubdto) {
        Club club= mapToClub(clubdto);
        repository.save(club);
    }

    private Club mapToClub(clubDTO DTO){
        return modelMapper.map(DTO,Club.class);
    }
    private clubDTO mapToClubDTO(Club club){
        return modelMapper.map(club,clubDTO.class);
    }
}
