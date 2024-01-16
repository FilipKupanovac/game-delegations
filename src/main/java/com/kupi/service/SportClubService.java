package com.kupi.service;

import com.kupi.rest.api.request.SportClubRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.SportClubDTO;

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
    SportClubDTO saveSportClub(SportClubRequest sportClubRequest);

    /**
     * Return sport club with provided identifier.
     *
     * @param id identifier of sport club
     * @return sport club representation
     */
    SportClubDTO getSportClubById(Long id);

    /**
     * Page sport clubs.
     *
     * @param params query params
     * @return page response
     */
    PagedResponse<SportClubDTO> getAllSportClubs(BasicPageQueryParams params);

    /**
     * Update sport club with provided identifier.
     *
     * @param id               identifier of sport club
     * @param sportClubRequest request to update sport club
     * @return updated sport club representation
     */
    SportClubDTO updateSportClub(Long id, SportClubRequest sportClubRequest);

    /**
     * Delete sport club with provided identifier.
     *
     * @param id sport club identifier
     */
    void deleteSportClub(Long id);
}
