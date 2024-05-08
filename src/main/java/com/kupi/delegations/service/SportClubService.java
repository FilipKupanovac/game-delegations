package com.kupi.delegations.service;

import com.kupi.delegations.rest.api.request.SportClubRequest;
import com.kupi.delegations.rest.api.response.PagedResponse;
import com.kupi.delegations.rest.dto.BasicPageQueryParams;
import com.kupi.delegations.rest.dto.SportClubDTO;

/**
 * Service interface for managing sport clubs in the system.
 */
public interface SportClubService {

    /**
     * Save sport club to the system.
     *
     * @param sportClubRequest request to create sports club
     * @return created sport club representation
     */
    SportClubDTO createSportClub(SportClubRequest sportClubRequest);

    /**
     * Return sport club with provided identifier.
     *
     * @param uuid identifier of sport club
     * @return sport club representation
     */
    SportClubDTO getSportClub(String uuid);

    /**
     * Page sport clubs.
     *
     * @param params query params
     * @return page response
     */
    PagedResponse<SportClubDTO> getSportClubs(BasicPageQueryParams params);

    /**
     * Update sport club with provided identifier.
     *
     * @param uuid             identifier of sport club
     * @param sportClubRequest request to update sport club
     * @return updated sport club representation
     */
    SportClubDTO updateSportClub(String uuid, SportClubRequest sportClubRequest);

    /**
     * Delete sport club with provided identifier.
     *
     * @param uuid sport club identifier
     */
    void deleteSportClub(String uuid);
}
