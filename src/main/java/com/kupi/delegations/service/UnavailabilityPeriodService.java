package com.kupi.delegations.service;

import com.kupi.delegations.rest.api.request.UnavailabilityPeriodRequest;
import com.kupi.delegations.rest.api.response.PagedResponse;
import com.kupi.delegations.rest.dto.BasicPageQueryParams;
import com.kupi.delegations.rest.dto.UnavailabilityPeriodDTO;

/**
 * Service interface for managing unavailability periods in the system.
 */
public interface UnavailabilityPeriodService {

    /**
     * Save unavailability period to the system.
     *
     * @param unavailabilityPeriodRequest request to create unavailability period
     * @return created unavailability period representation
     */
    UnavailabilityPeriodDTO createUnavailabilityPeriod(UnavailabilityPeriodRequest unavailabilityPeriodRequest);

    /**
     * Return unavailability period with provided UUID.
     *
     * @param uuid UUID of unavailability period
     * @return unavailability period representation
     */
    UnavailabilityPeriodDTO getUnavailabilityPeriodByUuid(String uuid);

    /**
     * Page unavailability periods.
     *
     * @param params query params
     * @return page response
     */
    PagedResponse<UnavailabilityPeriodDTO> getUnavailabilityPeriods(BasicPageQueryParams params);

    /**
     * Update unavailability period with provided UUID.
     *
     * @param uuid                         unavailability period UUID
     * @param unavailabilityPeriodRequest request to update unavailability period
     * @return updated unavailability period representation
     */
    UnavailabilityPeriodDTO updateUnavailabilityPeriod(String uuid, UnavailabilityPeriodRequest unavailabilityPeriodRequest);

    /**
     * Delete unavailability period with provided UUID.
     *
     * @param uuid unavailability period UUID
     */
    void deleteUnavailabilityPeriod(String uuid);
}
