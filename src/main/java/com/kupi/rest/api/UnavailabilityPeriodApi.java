package com.kupi.rest.api;

import com.kupi.rest.api.request.UnavailabilityPeriodRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.UnavailabilityPeriodDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/unavailability-period")
public interface UnavailabilityPeriodApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    UnavailabilityPeriodDTO createUnavailabilityPeriod(UnavailabilityPeriodRequest unavailabilityPeriodRequest);

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    UnavailabilityPeriodDTO getUnavailabilityPeriod(@PathParam("uuid") String uuid);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    PagedResponse<UnavailabilityPeriodDTO> getAllUnavailabilityPeriods(BasicPageQueryParams params);

    @PUT
    @Path("/{uuid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    UnavailabilityPeriodDTO updateUnavailabilityPeriod(@PathParam("uuid") String uuid, UnavailabilityPeriodRequest unavailabilityPeriodRequest);

    @DELETE
    @Path("/{uuid}")
    void deleteUnavailabilityPeriod(@PathParam("uuid") String uuid);
}