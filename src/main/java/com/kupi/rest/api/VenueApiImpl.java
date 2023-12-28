package com.kupi.rest.api;

import com.kupi.rest.dto.VenueDTO;
import com.kupi.service.VenueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueApiImpl implements VenueApi {

    private static final Logger log = LoggerFactory.getLogger(VenueApiImpl.class);

    private final VenueService venueService;

    public VenueApiImpl(VenueService venueService) {
        this.venueService = venueService;
    }

    @Override
    public VenueDTO createVenueDTO(VenueDTO venueDTO) {
        log.info("VenueApi.createVenueDTO [{}]", venueDTO);
        return venueService.saveVenue(venueDTO);
    }

    @Override
    public VenueDTO getVenueDTO(Long id) {
        log.info("VenueApi.getVenueDTO [{}]", id);
        return venueService.getVenueById(id);
    }

    @Override
    public List<VenueDTO> getAllVenuesDTO() {
        log.info("VenueApi.getAllVenuesDTO");
        return venueService.getAllVenues();
    }

    @Override
    public VenueDTO updateVenueDTO(Long id, VenueDTO venueDTO) {
        log.info("VenueApi.updateVenueDTO [id: {}, venueDTO: {}]", id, venueDTO);
        return venueService.updateVenue(id, venueDTO);
    }

    @Override
    public void deleteVenueDTO(Long id) {
        log.info("VenueApi.deleteVenueDTO [{}]", id);
        venueService.deleteVenue(id);
    }
}
