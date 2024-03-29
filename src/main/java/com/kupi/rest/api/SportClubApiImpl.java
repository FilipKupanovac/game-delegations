package com.kupi.rest.api;

import com.kupi.rest.api.request.SportClubRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.SportClubDTO;
import com.kupi.service.SportClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportClubApiImpl implements SportClubApi {

    private static final Logger log = LoggerFactory.getLogger(SportClubApiImpl.class);

    private final SportClubService sportClubService;

    public SportClubApiImpl(SportClubService sportClubService) {
        this.sportClubService = sportClubService;
    }

    @Override
    public SportClubDTO createSportsClub(SportClubRequest sportClubRequest) {
        log.info("SportsClubApi.createSportClub [{}]", sportClubRequest);
        return sportClubService.createSportClub(sportClubRequest);
    }

    @Override
    public SportClubDTO getSportsClub(String uuid) {
        log.info("SportsClubApi.getSportClub [{}]", uuid);
        return sportClubService.getSportClub(uuid);
    }

    @Override
    public PagedResponse<SportClubDTO> getSportsClubs(BasicPageQueryParams params) {
        log.info("SportsClubApi.getSportClubs [{}]", params);
        return sportClubService.getSportClubs(params);
    }

    @Override
    public SportClubDTO updateSportsClub(String uuid, SportClubRequest sportClubRequest) {
        log.info("SportsClubApi.updateSportClub [{}, {}]", uuid, sportClubRequest);
        return sportClubService.updateSportClub(uuid, sportClubRequest);
    }

    @Override
    public void deleteSportsClub(String uuid) {
        log.info("SportsClubApi.deleteSportClub [{}]", uuid);
        sportClubService.deleteSportClub(uuid);
    }
}
