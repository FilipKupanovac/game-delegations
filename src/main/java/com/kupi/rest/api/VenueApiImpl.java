package com.kupi.rest.api;

import com.kupi.rest.api.request.VenueRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.VenueDTO;
import com.kupi.service.VenueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VenueApiImpl implements VenueApi {

    private static final Logger log = LoggerFactory.getLogger(VenueApiImpl.class);

    private final VenueService venueService;

    public VenueApiImpl(VenueService venueService) {
        this.venueService = venueService;
    }

    @Override
    public VenueDTO createVenueDTO(VenueRequest venueRequest) {
        log.info("VenueApi.createVenueDTO [{}]", venueRequest);
        return venueService.saveVenue(venueRequest);
    }

    @Override
    public VenueDTO getVenueDTO(Long id) {
        log.info("VenueApi.getVenueDTO [{}]", id);
        return venueService.getVenueById(id);
    }

    @Override
    public PagedResponse<VenueDTO> getAllVenuesDTO(BasicPageQueryParams params) {
        log.info("VenueApi.getAllVenuesDTO [{}]", params);
        return venueService.getAllVenues(params);
    }

    @Override
    public VenueDTO updateVenueDTO(Long id, VenueRequest venueRequest) {
        log.info("VenueApi.updateVenueDTO [id: {}, venueDTO: {}]", id, venueRequest);
        return venueService.updateVenue(id, venueRequest);
    }

    @Override
    public void deleteVenueDTO(Long id) {
        log.info("VenueApi.deleteVenueDTO [{}]", id);
        venueService.deleteVenue(id);
    }
}
