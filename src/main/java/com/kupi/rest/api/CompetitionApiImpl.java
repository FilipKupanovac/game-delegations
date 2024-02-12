package com.kupi.rest.api;

import com.kupi.rest.api.request.CompetitionRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.CompetitionDTO;
import com.kupi.service.CompetitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompetitionApiImpl implements CompetitionApi {

    private static final Logger log = LoggerFactory.getLogger(CompetitionApiImpl.class);

    private final CompetitionService competitionService;

    public CompetitionApiImpl(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @Override
    public CompetitionDTO createCompetition(CompetitionRequest competitionRequest) {
        log.info("CompetitionApi.createCompetition [{}]", competitionRequest);
        return competitionService.saveCompetition(competitionRequest);
    }

    @Override
    public CompetitionDTO getCompetition(String uuid) {
        log.info("CompetitionApi.getCompetition [{}]", uuid);
        return competitionService.getCompetition(uuid);
    }

    @Override
    public PagedResponse<CompetitionDTO> getAllCompetitions(BasicPageQueryParams params) {
        log.info("CompetitionApi.getAllCompetitions [{}]", params);
        return competitionService.getAllCompetitions(params);
    }

    @Override
    public CompetitionDTO updateCompetition(String uuid, CompetitionRequest competitionRequest) {
        log.info("CompetitionApi.updateCompetition [uuid: {}, competitionDTO: {}]", uuid, competitionRequest);
        return competitionService.updateCompetition(uuid, competitionRequest);
    }

    @Override
    public void deleteCompetition(String uuid) {
        log.info("CompetitionApi.deleteCompetition [{}]", uuid);
        competitionService.deleteCompetition(uuid);
    }
}
