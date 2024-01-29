package com.kupi.rest.api;

import com.kupi.rest.api.request.CompetitionRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.CompetitionDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/competition")
public interface CompetitionApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    CompetitionDTO createCompetition(CompetitionRequest competitionRequest);

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    CompetitionDTO getCompetition(@PathParam("uuid") String uuid);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    PagedResponse<CompetitionDTO> getAllCompetitions(BasicPageQueryParams params);

    @PUT
    @Path("/{uuid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    CompetitionDTO updateCompetition(@PathParam("uuid") String uuid, CompetitionRequest competitionRequest);

    @DELETE
    @Path("/{uuid}")
    void deleteCompetition(@PathParam("uuid") String uuid);
}
