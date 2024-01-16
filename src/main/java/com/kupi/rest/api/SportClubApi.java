package com.kupi.rest.api;

import com.kupi.rest.api.request.SportClubRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.SportClubDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/sport-club")
public interface SportClubApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    SportClubDTO createSportsClubDTO(SportClubRequest sportClubRequest);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    SportClubDTO getSportsClubDTO(@PathParam("id") Long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    PagedResponse<SportClubDTO> getAllSportsClubsDTO(BasicPageQueryParams params);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    SportClubDTO updateSportsClubDTO(@PathParam("id") Long id, SportClubRequest sportClubRequest);

    @DELETE
    @Path("/{id}")
    void deleteSportsClubDTO(@PathParam("id") Long id);
}
