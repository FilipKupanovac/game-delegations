package com.kupi.rest.api;

import com.kupi.rest.dto.SportClubDTO;
import com.kupi.service.SportClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportClubApiImpl implements SportClubApi {

    private static final Logger log = LoggerFactory.getLogger(SportClubApiImpl.class);

    private final SportClubService sportClubService;

    public SportClubApiImpl(SportClubService sportClubService) {
        this.sportClubService = sportClubService;
    }

    @Override
    public SportClubDTO createSportsClubDTO(SportClubDTO sportClubDTO) {
        log.info("SportsClubApi.createSportClubDTO [{}]", sportClubDTO);
        return sportClubService.saveSportClub(sportClubDTO);
    }

    @Override
    public SportClubDTO getSportsClubDTO(Long id) {
        log.info("SportsClubApi.getSportClubDTO [{}]", id);
        return sportClubService.getSportClubById(id);
    }

    @Override
    public List<SportClubDTO> getAllSportsClubsDTO() {
        log.info("SportsClubApi.getAllSportClubsDTO");
        return sportClubService.getAllSportClubs();
    }

    @Override
    public SportClubDTO updateSportsClubDTO(Long id, SportClubDTO sportClubDTO) {
        log.info("SportsClubApi.updateSportClubDTO [{}, {}]", id, sportClubDTO);
        return sportClubService.updateSportClub(id, sportClubDTO);
    }

    @Override
    public void deleteSportsClubDTO(Long id) {
        log.info("SportsClubApi.deleteSportClubDTO [{}]", id);
        sportClubService.deleteSportClub(id);
    }
}
