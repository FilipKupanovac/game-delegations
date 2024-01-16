package com.kupi.service;

import com.kupi.rest.api.request.CompetitionRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.CompetitionDTO;

/**
 * Service interface for managing competitions in the system.
 */
public interface CompetitionService {

    /**
     * Saves competition to the system.
     *
     * @param competitionRequest request to create competition
     * @return created competition representation
     */
    CompetitionDTO saveCompetition(CompetitionRequest competitionRequest);

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
    PagedResponse<CompetitionDTO> getAllCompetitions(BasicPageQueryParams params);

    /**
     * Update competition with provided identifier.
     *
     * @param id                 competition identifier
     * @param competitionRequest request to update competition
     * @return updated competition representation
     */
    CompetitionDTO updateCompetition(Long id, CompetitionRequest competitionRequest);

    /**
     * Delete competition with provided identifier.
     *
     * @param id competition identifier
     */
    void deleteCompetition(Long id);
}
