package com.hf.running_application.services.impl;

import com.hf.running_application.exceptions.ClubNotFoundException;
import com.hf.running_application.model.ClubDTO;
import com.hf.running_application.entities.Club;
import com.hf.running_application.repository.clubrepository;
import com.hf.running_application.services.ClubService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.hf.running_application.mappers.ClubMapper;
import java.util.List;
import java.util.stream.Collectors;

import static com.hf.running_application.mappers.ClubMapper.mapToClub;
import static com.hf.running_application.mappers.ClubMapper.mapToClubDTO;

@Service
public class ClubServiceImpl implements ClubService {
    private clubrepository repository ;

    public ClubServiceImpl(clubrepository repository, ModelMapper modelMapper) {
        this.repository = repository;
    }

    @Override
    public List<ClubDTO> findAllClubs() {
        List<Club> getallclubs = repository.findAll();
        return getallclubs.stream().map(ClubMapper::mapToClubDTO).collect(Collectors.toList());
    }

    @Override
    public Club save(ClubDTO club) {
        Club club1 =mapToClub(club);
        repository.save(club1);
        return club1;
    }

    @Override
    public ClubDTO findClubById(long clubId) {
        Club clubs  = repository.findById(clubId).orElseThrow(()-> new ClubNotFoundException("Club Not Found",clubId));
        return mapToClubDTO(clubs);
    }

    @Override
    public void updateClub(ClubDTO clubdto) {
        Club club= mapToClub(clubdto);
        repository.save(club);
    }

    @Override
    public void deletebyId(Long clubId) {
        Club club = repository.findById(clubId).orElseThrow(()-> new ClubNotFoundException("Club Not Found",clubId));
        repository.deleteById(clubId);
    }

    @Override
    public List<ClubDTO> searchClubs(String title) {
        return  repository.searchClubs(title).stream().map(ClubMapper::mapToClubDTO).collect(Collectors.toList());
    }

}
