package com.kupi.service;

import com.kupi.rest.dto.VenueDTO;

import java.util.List;

/**
 * Service interface for managing venues in the system.
 */
public interface VenueService {

    /**
     * Saves a venue to the system.
     *
     * @param venueDTO representation of the venue
     * @return created venue representation
     */
    VenueDTO saveVenue(VenueDTO venueDTO);

    /**
     * Retrieves a venue with the provided identifier.
     *
     * @param id identifier of the venue
     * @return venue representation
     */
    VenueDTO getVenueById(Long id);

    /**
     * Retrieves a list of all venues in the system.
     *
     * @return list of venue representations
     */
    List<VenueDTO> getAllVenues();

    /**
     * Updates a venue with the provided identifier.
     *
     * @param id venue identifier
     * @param venueDTO fields to update
     * @return updated venue representation
     */
    VenueDTO updateVenue(Long id, VenueDTO venueDTO);

    /**
     * Deletes a venue with the provided identifier.
     *
     * @param id venue identifier
     */
    void deleteVenue(Long id);
}