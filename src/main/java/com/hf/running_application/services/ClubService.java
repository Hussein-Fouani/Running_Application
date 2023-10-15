package com.hf.running_application.services;

import com.hf.running_application.entities.Club;
import com.hf.running_application.model.ClubDTO;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAllClubs();

    Club save(ClubDTO club);

    ClubDTO findClubById(long clubId);

   void  updateClub(ClubDTO clubdto);

    void deletebyId(Long clubId);

    List<ClubDTO> searchClubs(String title);
}
