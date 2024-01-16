package com.kupi.rest.api;

import com.kupi.rest.api.request.VenueRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.VenueDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/venue")
public interface VenueApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    VenueDTO createVenueDTO(VenueRequest venueRequest);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    VenueDTO getVenueDTO(@PathParam("id") Long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    PagedResponse<VenueDTO> getAllVenuesDTO(BasicPageQueryParams params);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    VenueDTO updateVenueDTO(@PathParam("id") Long id, VenueRequest venueRequest);

    @DELETE
    @Path("/{id}")
    void deleteVenueDTO(@PathParam("id") Long id);
}
