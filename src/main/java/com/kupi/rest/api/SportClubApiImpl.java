package com.kupi.rest.api;

import com.kupi.rest.api.request.SportClubRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.SportClubDTO;
import com.kupi.service.SportClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SportClubApiImpl implements SportClubApi {

    private static final Logger log = LoggerFactory.getLogger(SportClubApiImpl.class);

    private final SportClubService sportClubService;

    public SportClubApiImpl(SportClubService sportClubService) {
        this.sportClubService = sportClubService;
    }

    @Override
    public SportClubDTO createSportsClubDTO(SportClubRequest sportClubRequest) {
        log.info("SportsClubApi.createSportClubDTO [{}]", sportClubRequest);
        return sportClubService.saveSportClub(sportClubRequest);
    }

    @Override
    public SportClubDTO getSportsClubDTO(Long id) {
        log.info("SportsClubApi.getSportClubDTO [{}]", id);
        return sportClubService.getSportClubById(id);
    }

    @Override
    public PagedResponse<SportClubDTO> getAllSportsClubsDTO(BasicPageQueryParams params) {
        log.info("SportsClubApi.getAllSportClubsDTO [{}]", params);
        return sportClubService.getAllSportClubs(params);
    }

    @Override
    public SportClubDTO updateSportsClubDTO(Long id, SportClubRequest sportClubRequest) {
        log.info("SportsClubApi.updateSportClubDTO [{}, {}]", id, sportClubRequest);
        return sportClubService.updateSportClub(id, sportClubRequest);
    }

    @Override
    public void deleteSportsClubDTO(Long id) {
        log.info("SportsClubApi.deleteSportClubDTO [{}]", id);
        sportClubService.deleteSportClub(id);
    }
}
