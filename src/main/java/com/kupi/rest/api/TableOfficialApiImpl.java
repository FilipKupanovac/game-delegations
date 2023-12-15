/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.rest.api;

import com.kupi.rest.dto.TableOfficialDTO;
import com.kupi.service.TableOfficialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableOfficialApiImpl implements TableOfficialApi {

    private static final Logger log = LoggerFactory.getLogger(TableOfficialApiImpl.class);

    private final TableOfficialService tableOfficialService;

    public TableOfficialApiImpl(TableOfficialService tableOfficialService) {
        this.tableOfficialService = tableOfficialService;
    }

    @Override
    public TableOfficialDTO createTableOfficialDTO(TableOfficialDTO tableOfficialDTO) {
        log.info("TableOfficialApi.createTableOfficialDTO [{}]", tableOfficialDTO);
        return tableOfficialService.saveTableOfficial(tableOfficialDTO);
    }

    @Override
    public TableOfficialDTO getTableOfficialDTO(Long id) {
        log.info("TableOfficialApi.getTableOfficialDTO [{}]", id);
        return tableOfficialService.getTableOfficialById(id);
    }

    @Override
    public List<TableOfficialDTO> getAllTableOfficialsDTO() {
        log.info("TableOfficialApi.getAllTableOfficialsDTO");
        return tableOfficialService.getAllTableOfficials();
    }

    @Override
    public TableOfficialDTO updateTableOfficialDTO(Long id, TableOfficialDTO tableOfficialDTO) {
        log.info("TableOfficialApi.updateTableOfficialDTO [id: {}, tableOfficialDTO: {}]", id, tableOfficialDTO);
        return tableOfficialService.updateTableOfficial(id, tableOfficialDTO);
    }

    @Override
    public void deleteTableOfficialDTO(Long id) {
        log.info("TableOfficialApi.deleteTableOfficialDTO [{}]", id);
        tableOfficialService.deleteTableOfficial(id);
    }
}
