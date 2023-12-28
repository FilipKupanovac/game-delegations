package com.kupi.service;

import com.kupi.rest.dto.TableOfficialDTO;

import java.util.List;

public interface TableOfficialService {

    TableOfficialDTO saveTableOfficial(TableOfficialDTO tableOfficialDTO);

    TableOfficialDTO getTableOfficialById(Long id);

    List<TableOfficialDTO> getAllTableOfficials();

    TableOfficialDTO updateTableOfficial(Long id, TableOfficialDTO tableOfficialDTO);

    void deleteTableOfficial(Long id);
}
