package com.kupi.rest.api;

import com.kupi.rest.api.request.AssignmentRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.AssignmentDTO;
import com.kupi.rest.dto.BasicPageQueryParams;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/assignments")
public interface AssignmentApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    AssignmentDTO createAssignment(AssignmentRequest assignmentRequest);

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    AssignmentDTO getAssignment(@PathParam("uuid") String uuid);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    PagedResponse<AssignmentDTO> getAssignments(BasicPageQueryParams params);

    @PUT
    @Path("/{uuid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    AssignmentDTO updateAssignment(@PathParam("uuid") String uuid, AssignmentRequest assignmentRequest);

    @DELETE
    @Path("/{uuid}")
    void deleteAssignment(@PathParam("uuid") String uuid);
}
