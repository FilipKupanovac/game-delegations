package com.kupi.rest.api;

import com.kupi.rest.api.request.CompetitionRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.CompetitionDTO;
import com.kupi.service.CompetitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CompetitionApiImpl implements CompetitionApi {

    private static final Logger log = LoggerFactory.getLogger(CompetitionApiImpl.class);

    private final CompetitionService competitionService;

    public CompetitionApiImpl(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @Override
    public CompetitionDTO createCompetitionDTO(CompetitionRequest competitionRequest) {
        log.info("CompetitionApi.createCompetitionDTO [{}]", competitionRequest);
        return competitionService.saveCompetition(competitionRequest);
    }

    @Override
    public CompetitionDTO getCompetitionDTO(Long id) {
        log.info("CompetitionApi.getCompetitionDTO [{}]", id);
        return competitionService.getCompetitionById(id);
    }

    @Override
    public PagedResponse<CompetitionDTO> getAllCompetitionsDTO(BasicPageQueryParams params) {
        log.info("CompetitionApi.getAllCompetitionsDTO[{}]", params);
        return competitionService.getAllCompetitions(params);
    }

    @Override
    public CompetitionDTO updateCompetitionDTO(Long id, CompetitionRequest competitionRequest) {
        log.info("CompetitionApi.updateCompetitionDTO [id: {}, competitionDTO: {}]", id, competitionRequest);
        return competitionService.updateCompetition(id, competitionRequest);
    }

    @Override
    public void deleteCompetitionDTO(Long id) {
        log.info("CompetitionApi.deleteCompetitionDTO [{}]", id);
        competitionService.deleteCompetition(id);
    }
}
