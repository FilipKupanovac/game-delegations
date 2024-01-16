package com.kupi.rest.api;

import com.kupi.rest.api.request.TableOfficialRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.TableOfficialDTO;
import com.kupi.service.TableOfficialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TableOfficialApiImpl implements TableOfficialApi {

    private static final Logger log = LoggerFactory.getLogger(TableOfficialApiImpl.class);

    private final TableOfficialService tableOfficialService;

    public TableOfficialApiImpl(TableOfficialService tableOfficialService) {
        this.tableOfficialService = tableOfficialService;
    }

    @Override
    public TableOfficialDTO createTableOfficialDTO(TableOfficialRequest tableOfficialRequest) {
        log.info("TableOfficialApi.createTableOfficialDTO [{}]", tableOfficialRequest);
        return tableOfficialService.saveTableOfficial(tableOfficialRequest);
    }

    @Override
    public TableOfficialDTO getTableOfficialDTO(Long id) {
        log.info("TableOfficialApi.getTableOfficialDTO [{}]", id);
        return tableOfficialService.getTableOfficialById(id);
    }

    @Override
    public PagedResponse<TableOfficialDTO> getAllTableOfficialsDTO(BasicPageQueryParams params) {
        log.info("TableOfficialApi.getAllTableOfficialsDTO [{}]", params);
        return tableOfficialService.getAllTableOfficials(params);
    }

    @Override
    public TableOfficialDTO updateTableOfficialDTO(Long id, TableOfficialRequest tableOfficialRequest) {
        log.info("TableOfficialApi.updateTableOfficialDTO [id: {}, tableOfficialDTO: {}]", id, tableOfficialRequest);
        return tableOfficialService.updateTableOfficial(id, tableOfficialRequest);
    }

    @Override
    public void deleteTableOfficialDTO(Long id) {
        log.info("TableOfficialApi.deleteTableOfficialDTO [{}]", id);
        tableOfficialService.deleteTableOfficial(id);
    }
}
