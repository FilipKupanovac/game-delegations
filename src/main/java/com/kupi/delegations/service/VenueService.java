package com.kupi.delegations.service;

import com.kupi.delegations.rest.api.request.VenueRequest;
import com.kupi.delegations.rest.api.response.PagedResponse;
import com.kupi.delegations.rest.dto.BasicPageQueryParams;
import com.kupi.delegations.rest.dto.VenueDTO;

/**
 * Service interface for managing venues in the system.
 */
public interface VenueService {

    /**
     * Saves a venue to the system.
     *
     * @param venueRequest request to create venue
     * @return created venue representation
     */
    VenueDTO createVenue(VenueRequest venueRequest);

    /**
     * Retrieves a venue with the provided identifier.
     *
     * @param uuid identifier of the venue
     * @return venue representation
     */
    VenueDTO getVenue(String uuid);

    /**
     * Retrieves a list of all venues in the system.
     *
     * @return list of venue representations
     */
    PagedResponse<VenueDTO> getAllVenues(BasicPageQueryParams params);

    /**
     * Updates a venue with the provided identifier.
     *
     * @param uuid         venue identifier
     * @param venueRequest request to update venue
     * @return updated venue representation
     */
    VenueDTO updateVenue(String uuid, VenueRequest venueRequest);

    /**
     * Deletes a venue with the provided identifier.
     *
     * @param uuid venue identifier
     */
    void deleteVenue(String uuid);
}