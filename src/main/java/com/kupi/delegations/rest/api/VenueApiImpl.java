package com.kupi.delegations.rest.api;

import com.kupi.delegations.rest.api.request.VenueRequest;
import com.kupi.delegations.rest.dto.BasicPageQueryParams;
import com.kupi.delegations.rest.dto.VenueDTO;
import com.kupi.delegations.rest.api.response.PagedResponse;
import com.kupi.delegations.service.VenueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VenueApiImpl implements VenueApi {

    private static final Logger log = LoggerFactory.getLogger(VenueApiImpl.class);

    private final VenueService venueService;

    public VenueApiImpl(VenueService venueService) {
        this.venueService = venueService;
        log.info(this.getClass().getName() + " successfully initialized");
    }

    @Override
    public VenueDTO createVenue(VenueRequest venueRequest) {
        log.info("VenueApi.createVenue [{}]", venueRequest);
        return venueService.createVenue(venueRequest);
    }

    @Override
    public VenueDTO getVenue(String uuid) {
        log.info("VenueApi.getVenue [{}]", uuid);
        return venueService.getVenue(uuid);
    }

    @Override
    public PagedResponse<VenueDTO> getAllVenues(BasicPageQueryParams params) {
        log.info("VenueApi.getAllVenues [{}]", params);
        return venueService.getAllVenues(params);
    }

    @Override
    public VenueDTO updateVenue(String uuid, VenueRequest venueRequest) {
        log.info("VenueApi.updateVenue [{}, {}]", uuid, venueRequest);
        return venueService.updateVenue(uuid, venueRequest);
    }

    @Override
    public void deleteVenue(String uuid) {
        log.info("VenueApi.deleteVenue [{}]", uuid);
        venueService.deleteVenue(uuid);
    }
}
