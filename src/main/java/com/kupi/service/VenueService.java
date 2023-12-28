package com.kupi.service;

import com.kupi.rest.dto.VenueDTO;

import java.util.List;

public interface VenueService {

    VenueDTO saveVenue(VenueDTO venueDTO);

    VenueDTO getVenueById(Long id);

    List<VenueDTO> getAllVenues();

    VenueDTO updateVenue(Long id, VenueDTO venueDTO);

    void deleteVenue(Long id);
}
