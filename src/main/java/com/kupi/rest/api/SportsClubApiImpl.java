package com.kupi.rest.api;

import com.kupi.rest.dto.SportsClubDTO;
import com.kupi.service.SportsClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsClubApiImpl implements SportsClubApi {

    private static final Logger log = LoggerFactory.getLogger(SportsClubApiImpl.class);

    private final SportsClubService sportsClubService;

    public SportsClubApiImpl(SportsClubService sportsClubService) {
        this.sportsClubService = sportsClubService;
    }

    @Override
    public SportsClubDTO createSportsClubDTO(SportsClubDTO sportsClubDTO) {
        log.info("SportsClubApi.createSportsClubDTO [{}]", sportsClubDTO);
        return sportsClubService.saveSportsClub(sportsClubDTO);
    }

    @Override
    public SportsClubDTO getSportsClubDTO(Long id) {
        log.info("SportsClubApi.getSportsClubDTO [{}]", id);
        return sportsClubService.getSportsClubById(id);
    }

    @Override
    public List<SportsClubDTO> getAllSportsClubsDTO() {
        log.info("SportsClubApi.getAllSportsClubsDTO");
        return sportsClubService.getAllSportsClubs();
    }

    @Override
    public SportsClubDTO updateSportsClubDTO(Long id, SportsClubDTO sportsClubDTO) {
        log.info("SportsClubApi.updateSportsClubDTO [id: {}, sportsClubDTO: {}]", id, sportsClubDTO);
        return sportsClubService.updateSportsClub(id, sportsClubDTO);
    }

    @Override
    public void deleteSportsClubDTO(Long id) {
        log.info("SportsClubApi.deleteSportsClubDTO [{}]", id);
        sportsClubService.deleteSportsClub(id);
    }
}
