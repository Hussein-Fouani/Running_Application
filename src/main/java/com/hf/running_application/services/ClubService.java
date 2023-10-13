package com.hf.running_application.services;

import com.hf.running_application.model.clubDTO;

import java.util.List;

public interface ClubService {
    List<clubDTO> findAllClubs();
}
