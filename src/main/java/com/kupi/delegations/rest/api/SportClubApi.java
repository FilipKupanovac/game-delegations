package com.kupi.delegations.rest.api;

import com.kupi.delegations.rest.api.request.SportClubRequest;
import com.kupi.delegations.rest.api.response.PagedResponse;
import com.kupi.delegations.rest.dto.BasicPageQueryParams;
import com.kupi.delegations.rest.dto.SportClubDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/frontend/sport-clubs")
public interface SportClubApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    SportClubDTO createSportsClub(SportClubRequest sportClubRequest);

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    SportClubDTO getSportsClub(@PathParam("uuid") String uuid);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    PagedResponse<SportClubDTO> getSportsClubs(BasicPageQueryParams params);

    @PUT
    @Path("/{uuid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    SportClubDTO updateSportsClub(@PathParam("uuid") String uuid, SportClubRequest sportClubRequest);

    @DELETE
    @Path("/{uuid}")
    void deleteSportsClub(@PathParam("uuid") String uuid);
}
