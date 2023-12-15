/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.service;

import com.kupi.persistence.repository.TableOfficialRepository;
import com.kupi.rest.dto.TableOfficialDTO;
import com.kupi.service.mapper.TableOfficialMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableOfficialServiceImpl implements TableOfficialService {

    private final TableOfficialRepository tableOfficialRepository;
    private final TableOfficialMapper tableOfficialMapper;

    public TableOfficialServiceImpl(TableOfficialRepository tableOfficialRepository, TableOfficialMapper tableOfficialMapper) {
        this.tableOfficialRepository = tableOfficialRepository;
        this.tableOfficialMapper = tableOfficialMapper;
    }

    @Override
    public TableOfficialDTO saveTableOfficial(TableOfficialDTO tableOfficialDTO) {
        // Stub implementation
        return null;
    }

    @Override
    public TableOfficialDTO getTableOfficialById(Long id) {
        // Stub implementation
        return null;
    }

    @Override
    public List<TableOfficialDTO> getAllTableOfficials() {
        // Stub implementation
        return null;
    }

    @Override
    public TableOfficialDTO updateTableOfficial(Long id, TableOfficialDTO tableOfficialDTO) {
        // Stub implementation
        return null;
    }

    @Override
    public void deleteTableOfficial(Long id) {
        // Stub implementation
    }
}
