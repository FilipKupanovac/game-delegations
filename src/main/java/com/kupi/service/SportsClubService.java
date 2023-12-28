package com.kupi.service;

import com.kupi.rest.dto.SportsClubDTO;

import java.util.List;

public interface SportsClubService {

    SportsClubDTO saveSportsClub(SportsClubDTO sportsClubDTO);

    SportsClubDTO getSportsClubById(Long id);

    List<SportsClubDTO> getAllSportsClubs();

    SportsClubDTO updateSportsClub(Long id, SportsClubDTO sportsClubDTO);

    void deleteSportsClub(Long id);
}
