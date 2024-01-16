package com.kupi.service;

import com.kupi.rest.api.request.TableOfficialRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.TableOfficialDTO;

/**
 * Service interface for managing table officials in the system.
 */
public interface TableOfficialService {
    /**
     * Saves table official to the system.
     *
     * @param tableOfficialRequest request to create table official
     * @return created table official representation
     */
    TableOfficialDTO saveTableOfficial(TableOfficialRequest tableOfficialRequest);

    /**
     * Return table official with provided id.
     *
     * @param id identifier of table official
     * @return table official representation
     */
    TableOfficialDTO getTableOfficialById(Long id);

    /**
     * Page table officials.
     *
     * @param params query params
     * @return page
     */
    PagedResponse<TableOfficialDTO> getAllTableOfficials(BasicPageQueryParams params);

    /**
     * Update table official with provided identifier.
     *
     * @param id                   table official identifier
     * @param tableOfficialRequest request to update table official
     * @return updated table official representation
     */
    TableOfficialDTO updateTableOfficial(Long id, TableOfficialRequest tableOfficialRequest);

    /**
     * Delete table official with provided identifier.
     *
     * @param id table official identifier
     */
    void deleteTableOfficial(Long id);
}
