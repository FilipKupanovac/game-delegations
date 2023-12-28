package com.kupi.service;

import com.kupi.rest.dto.CompetitionDTO;

import java.util.List;

public interface CompetitionService {

    CompetitionDTO saveCompetition(CompetitionDTO competitionDTO);

    CompetitionDTO getCompetitionById(Long id);

    List<CompetitionDTO> getAllCompetitions();

    CompetitionDTO updateCompetition(Long id, CompetitionDTO competitionDTO);

    void deleteCompetition(Long id);
}
