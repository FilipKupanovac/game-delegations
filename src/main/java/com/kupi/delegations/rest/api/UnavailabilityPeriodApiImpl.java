package com.kupi.delegations.rest.api;

import com.kupi.delegations.rest.api.request.UnavailabilityPeriodRequest;
import com.kupi.delegations.rest.api.response.PagedResponse;
import com.kupi.delegations.rest.dto.BasicPageQueryParams;
import com.kupi.delegations.rest.dto.UnavailabilityPeriodDTO;
import com.kupi.delegations.service.UnavailabilityPeriodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnavailabilityPeriodApiImpl implements UnavailabilityPeriodApi {

    private static final Logger log = LoggerFactory.getLogger(UnavailabilityPeriodApiImpl.class);

    private final UnavailabilityPeriodService unavailabilityPeriodService;

    public UnavailabilityPeriodApiImpl(UnavailabilityPeriodService unavailabilityPeriodService) {
        this.unavailabilityPeriodService = unavailabilityPeriodService;
        log.info(this.getClass().getName() + " successfully initialized");
    }

    @Override
    public UnavailabilityPeriodDTO createUnavailabilityPeriod(UnavailabilityPeriodRequest unavailabilityPeriodRequest) {
        log.info("UnavailabilityPeriodApi.createUnavailabilityPeriod [{}]", unavailabilityPeriodRequest);
        return unavailabilityPeriodService.createUnavailabilityPeriod(unavailabilityPeriodRequest);
    }

    @Override
    public UnavailabilityPeriodDTO getUnavailabilityPeriod(String uuid) {
        log.info("UnavailabilityPeriodApi.getUnavailabilityPeriod [{}]", uuid);
        return unavailabilityPeriodService.getUnavailabilityPeriodByUuid(uuid);
    }

    @Override
    public PagedResponse<UnavailabilityPeriodDTO> getUnavailabilityPeriods(BasicPageQueryParams params) {
        log.info("UnavailabilityPeriodApi.getUnavailabilityPeriods [{}]", params);
        return unavailabilityPeriodService.getUnavailabilityPeriods(params);
    }

    @Override
    public UnavailabilityPeriodDTO updateUnavailabilityPeriod(String uuid, UnavailabilityPeriodRequest unavailabilityPeriodRequest) {
        log.info("UnavailabilityPeriodApi.updateUnavailabilityPeriod [{}, {}]", uuid, unavailabilityPeriodRequest);
        return unavailabilityPeriodService.updateUnavailabilityPeriod(uuid, unavailabilityPeriodRequest);
    }

    @Override
    public void deleteUnavailabilityPeriod(String uuid) {
        log.info("UnavailabilityPeriodApi.deleteUnavailabilityPeriod [{}]", uuid);
        unavailabilityPeriodService.deleteUnavailabilityPeriod(uuid);
    }
}