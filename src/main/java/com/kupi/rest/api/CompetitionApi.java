package com.kupi.rest.api;

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

import java.util.List;

@Path("/v1/competition")
public interface CompetitionApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    CompetitionDTO createCompetitionDTO(CompetitionDTO competitionDTO);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    CompetitionDTO getCompetitionDTO(@PathParam("id") Long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<CompetitionDTO> getAllCompetitionsDTO();

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    CompetitionDTO updateCompetitionDTO(@PathParam("id") Long id, CompetitionDTO competitionDTO);

    @DELETE
    @Path("/{id}")
    void deleteCompetitionDTO(@PathParam("id") Long id);
}
