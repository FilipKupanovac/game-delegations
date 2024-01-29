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
    public VenueDTO getVenueDTO(String uuid) {
        log.info("VenueApi.getVenueDTO [{}]", uuid);
        return venueService.getVenueById(uuid);
    }

    @Override
    public PagedResponse<VenueDTO> getAllVenuesDTO(BasicPageQueryParams params) {
        log.info("VenueApi.getAllVenuesDTO [{}]", params);
        return venueService.getAllVenues(params);
    }

    @Override
    public VenueDTO updateVenueDTO(String uuid, VenueRequest venueRequest) {
        log.info("VenueApi.updateVenueDTO [uuid: {}, venueDTO: {}]", uuid, venueRequest);
        return venueService.updateVenue(uuid, venueRequest);
    }

    @Override
    public void deleteVenueDTO(String uuid) {
        log.info("VenueApi.deleteVenueDTO [{}]", uuid);
        venueService.deleteVenue(uuid);
    }
}
