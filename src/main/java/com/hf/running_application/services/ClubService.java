package com.hf.running_application.services;

import com.hf.running_application.entities.Club;
import com.hf.running_application.model.clubDTO;

import java.util.List;

public interface ClubService {
    List<clubDTO> findAllClubs();

    Club save(Club club);

    clubDTO findClubById(long clubId);

   void  updateClub(clubDTO clubdto);
}
