package com.kupi.rest.api;

import com.kupi.rest.api.request.UnavailabilityPeriodRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.UnavailabilityPeriodDTO;
import com.kupi.service.UnavailabilityPeriodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UnavailabilityPeriodApiImpl implements UnavailabilityPeriodApi {

    private static final Logger log = LoggerFactory.getLogger(UnavailabilityPeriodApiImpl.class);

    private final UnavailabilityPeriodService unavailabilityPeriodService;

    public UnavailabilityPeriodApiImpl(UnavailabilityPeriodService unavailabilityPeriodService) {
        this.unavailabilityPeriodService = unavailabilityPeriodService;
    }

    @Override
    public UnavailabilityPeriodDTO createUnavailabilityPeriod(UnavailabilityPeriodRequest unavailabilityPeriodRequest) {
        log.info("UnavailabilityPeriodApi.createUnavailabilityPeriod [{}]", unavailabilityPeriodRequest);
        return unavailabilityPeriodService.saveUnavailabilityPeriod(unavailabilityPeriodRequest);
    }

    @Override
    public UnavailabilityPeriodDTO getUnavailabilityPeriod(String uuid) {
        log.info("UnavailabilityPeriodApi.getUnavailabilityPeriod [{}]", uuid);
        return unavailabilityPeriodService.getUnavailabilityPeriodByUuid(uuid);
    }

    @Override
    public PagedResponse<UnavailabilityPeriodDTO> getAllUnavailabilityPeriods(BasicPageQueryParams params) {
        log.info("UnavailabilityPeriodApi.getAllUnavailabilityPeriods [{}]", params);
        return unavailabilityPeriodService.getAllUnavailabilityPeriods(params);
    }

    @Override
    public UnavailabilityPeriodDTO updateUnavailabilityPeriod(String uuid, UnavailabilityPeriodRequest unavailabilityPeriodRequest) {
        log.info("UnavailabilityPeriodApi.updateUnavailabilityPeriod [uuid: {}, unavailabilityPeriodDTO: {}]", uuid, unavailabilityPeriodRequest);
        return unavailabilityPeriodService.updateUnavailabilityPeriod(uuid, unavailabilityPeriodRequest);
    }

    @Override
    public void deleteUnavailabilityPeriod(String uuid) {
        log.info("UnavailabilityPeriodApi.deleteUnavailabilityPeriod [{}]", uuid);
        unavailabilityPeriodService.deleteUnavailabilityPeriod(uuid);
    }
}