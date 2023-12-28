package com.kupi.service;

import com.kupi.rest.dto.TableOfficialDTO;

import java.util.List;

/**
 * Service interface for managing table officials in the system.
 */
public interface TableOfficialService {
    /**
     * Saves table official to the system.
     *
     * @param tableOfficialDTO representation of table official
     * @return created table official representation
     */
    TableOfficialDTO saveTableOfficial(TableOfficialDTO tableOfficialDTO);

    /**
     * Return table official with provided id.
     *
     * @param id identifier of table official
     * @return table official representation
     */
    TableOfficialDTO getTableOfficialById(Long id);

    List<TableOfficialDTO> getAllTableOfficials();

    /**
     * Update table official with provided identifier.
     *
     * @param id               table official identifier
     * @param tableOfficialDTO fields to update
     * @return updated table official representation
     */
    TableOfficialDTO updateTableOfficial(Long id, TableOfficialDTO tableOfficialDTO);

    /**
     * Delete table official with provided identifier.
     *
     * @param id table official identifier
     */
    void deleteTableOfficial(Long id);
}
