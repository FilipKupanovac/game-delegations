package com.kupi.delegations.rest.api;

import com.kupi.delegations.rest.api.request.TableOfficialRequest;
import com.kupi.delegations.rest.dto.BasicPageQueryParams;
import com.kupi.delegations.rest.dto.TableOfficialDTO;
import com.kupi.delegations.rest.api.response.PagedResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/frontend/table-officials")
public interface TableOfficialApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    TableOfficialDTO createTableOfficial(TableOfficialRequest tableOfficialRequest);

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    TableOfficialDTO getTableOfficial(@PathParam("uuid") String uuid);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    PagedResponse<TableOfficialDTO> getTableOfficials(BasicPageQueryParams params);

    @PUT
    @Path("/{uuid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    TableOfficialDTO updateTableOfficial(@PathParam("uuid") String uuid, TableOfficialRequest tableOfficialRequest);

    @DELETE
    @Path("/{uuid}")
    void deleteTableOfficial(@PathParam("uuid") String uuid);
}
