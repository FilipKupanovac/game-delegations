package com.kupi.rest.api;

import com.kupi.rest.api.request.TableOfficialRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.TableOfficialDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/table-official")
public interface TableOfficialApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    TableOfficialDTO createTableOfficialDTO(TableOfficialRequest tableOfficialRequest);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    TableOfficialDTO getTableOfficialDTO(@PathParam("id") Long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    PagedResponse<TableOfficialDTO> getAllTableOfficialsDTO(BasicPageQueryParams params);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    TableOfficialDTO updateTableOfficialDTO(@PathParam("id") Long id, TableOfficialRequest tableOfficialRequest);

    @DELETE
    @Path("/{id}")
    void deleteTableOfficialDTO(@PathParam("id") Long id);
}
