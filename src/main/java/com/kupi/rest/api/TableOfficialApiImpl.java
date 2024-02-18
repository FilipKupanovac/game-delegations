package com.kupi.rest.api;

import com.kupi.rest.api.request.TableOfficialRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.TableOfficialDTO;
import com.kupi.service.TableOfficialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableOfficialApiImpl implements TableOfficialApi {

    private static final Logger log = LoggerFactory.getLogger(TableOfficialApiImpl.class);

    private final TableOfficialService tableOfficialService;

    public TableOfficialApiImpl(TableOfficialService tableOfficialService) {
        this.tableOfficialService = tableOfficialService;
    }

    @Override
    public TableOfficialDTO createTableOfficial(TableOfficialRequest tableOfficialRequest) {
        log.info("TableOfficialApi.createTableOfficial [{}]", tableOfficialRequest);
        return tableOfficialService.saveTableOfficial(tableOfficialRequest);
    }

    @Override
    public TableOfficialDTO getTableOfficial(String uuid) {
        log.info("TableOfficialApi.getTableOfficial [{}]", uuid);
        return tableOfficialService.getTableOfficial(uuid);
    }

    @Override
    public PagedResponse<TableOfficialDTO> getTableOfficials(BasicPageQueryParams params) {
        log.info("TableOfficialApi.getTableOfficials [{}]", params);
        return tableOfficialService.getTableOfficials(params);
    }

    @Override
    public TableOfficialDTO updateTableOfficial(String uuid, TableOfficialRequest tableOfficialRequest) {
        log.info("TableOfficialApi.updateTableOfficial [{}, {}]", uuid, tableOfficialRequest);
        return tableOfficialService.updateTableOfficial(uuid, tableOfficialRequest);
    }

    @Override
    public void deleteTableOfficial(String uuid) {
        log.info("TableOfficialApi.deleteTableOfficial [{}]", uuid);
        tableOfficialService.deleteTableOfficial(uuid);
    }
}
