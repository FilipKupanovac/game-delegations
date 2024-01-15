package com.kupi.service;

import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.CompetitionDTO;
import com.kupi.rest.dto.CompetitionQueryParamsDTO;

/**
 * Service interface for managing competitions in the system.
 */
public interface CompetitionService {

    /**
     * Saves competition to the system.
     *
     * @param competitionDTO representation of competition
     * @return created competition representation
     */
    CompetitionDTO saveCompetition(CompetitionDTO competitionDTO);

    /**
     * Return competition with provided identifier.
     *
     * @param id identifier of competition
     * @return competition representation
     */
    CompetitionDTO getCompetitionById(Long id);

    /**
     * Page competitions.
     *
     * @param params query params
     * @return page response
     */
    PagedResponse<CompetitionDTO> getAllCompetitions(CompetitionQueryParamsDTO params);

    /**
     * Update competition with provided identifier.
     *
     * @param id             competition identifier
     * @param competitionDTO fields to update
     * @return updated competition representation
     */
    CompetitionDTO updateCompetition(Long id, CompetitionDTO competitionDTO);

    /**
     * Delete competition with provided identifier.
     *
     * @param id competition identifier
     */
    void deleteCompetition(Long id);
}
