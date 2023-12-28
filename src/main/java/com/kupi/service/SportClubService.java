package com.kupi.service;

import com.kupi.rest.dto.SportClubDTO;

import java.util.List;

/**
 * Service interface for managing sport clubs in the system.
 */
public interface SportClubService {

    /**
     * Save sport club to the system.
     *
     * @param sportClubDTO representation of sport club
     * @return created sport club representation
     */
    SportClubDTO saveSportClub(SportClubDTO sportClubDTO);

    /**
     * Return sport club with provided identifier.
     *
     * @param id identifier of sport club
     * @return sport club representation
     */
    SportClubDTO getSportClubById(Long id);

    List<SportClubDTO> getAllSportClubs();

    /**
     * Update sport club with provided identifier.
     *
     * @param id           identifier of sport club
     * @param sportClubDTO fields to update
     * @return updated sport club representation
     */
    SportClubDTO updateSportClub(Long id, SportClubDTO sportClubDTO);

    /**
     * Delete sport club with provided identifier.
     *
     * @param id sport club identifier
     */
    void deleteSportClub(Long id);
}
