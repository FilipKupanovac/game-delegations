package com.kupi.rest.api;

import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.CompetitionDTO;
import com.kupi.rest.dto.CompetitionQueryParamsDTO;
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
    public CompetitionDTO createCompetitionDTO(CompetitionDTO competitionDTO) {
        log.info("CompetitionApi.createCompetitionDTO [{}]", competitionDTO);
        return competitionService.saveCompetition(competitionDTO);
    }

    @Override
    public CompetitionDTO getCompetitionDTO(Long id) {
        log.info("CompetitionApi.getCompetitionDTO [{}]", id);
        return competitionService.getCompetitionById(id);
    }

    @Override
    public PagedResponse<CompetitionDTO> getAllCompetitionsDTO(CompetitionQueryParamsDTO params) {
        log.info("CompetitionApi.getAllCompetitionsDTO");
        return competitionService.getAllCompetitions(params);
    }

    @Override
    public CompetitionDTO updateCompetitionDTO(Long id, CompetitionDTO competitionDTO) {
        log.info("CompetitionApi.updateCompetitionDTO [id: {}, competitionDTO: {}]", id, competitionDTO);
        return competitionService.updateCompetition(id, competitionDTO);
    }

    @Override
    public void deleteCompetitionDTO(Long id) {
        log.info("CompetitionApi.deleteCompetitionDTO [{}]", id);
        competitionService.deleteCompetition(id);
    }
}
