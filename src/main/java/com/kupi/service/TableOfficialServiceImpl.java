package com.kupi.service;

import com.kupi.persistence.entity.TableOfficialEntity;
import com.kupi.persistence.repository.TableOfficialRepository;
import com.kupi.rest.api.request.TableOfficialRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.TableOfficialDTO;
import com.kupi.service.mapper.TableOfficialMapper;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

@Service
public class TableOfficialServiceImpl implements TableOfficialService {

    private final TableOfficialRepository tableOfficialRepository;
    private final TableOfficialMapper tableOfficialMapper;
    private final IdGenerator idGenerator;

    public TableOfficialServiceImpl(TableOfficialRepository tableOfficialRepository, TableOfficialMapper tableOfficialMapper, IdGenerator idGenerator) {
        this.tableOfficialRepository = tableOfficialRepository;
        this.tableOfficialMapper = tableOfficialMapper;
        this.idGenerator = idGenerator;
    }

    @Override
    public TableOfficialDTO saveTableOfficial(TableOfficialRequest tableOfficialRequest) {
        TableOfficialEntity tableOfficialEntity = tableOfficialMapper.toEntity(tableOfficialRequest);
        tableOfficialEntity.setUuid(idGenerator.generateId().toString());
        return tableOfficialMapper.toDTO(tableOfficialRepository.save(tableOfficialEntity));
    }

    @Override
    public TableOfficialDTO getTableOfficialById(Long id) {
        return tableOfficialMapper.toDTO(getById(id));
    }

    @Override
    public PagedResponse<TableOfficialDTO> getAllTableOfficials(BasicPageQueryParams params) {
        PageRequest pageRequest = PageRequest.of(
                params.getPage(),
                params.getSize(),
                Sort.Direction.fromOptionalString(params.getDirection()).orElse(Sort.Direction.ASC),
                StringUtils.isNotBlank(params.getColumn()) ? params.getColumn() : "key"
        );
        if (tableOfficialRepository.count() < 1) {
            return PagedResponse.fromPage(Page.empty());
        }
        Page<TableOfficialEntity> pageSlice = tableOfficialRepository.findAll(pageRequest);
        Page<TableOfficialDTO> pageSliceDTO = pageSlice.map(tableOfficialMapper::toDTO);
        PagedResponse<TableOfficialDTO> pagedResponse = PagedResponse.fromPage(pageSliceDTO);

        if (params.getPage() > pagedResponse.getTotalPages()) {
            throw new RuntimeException("Page out of bounds!");
        }
        return pagedResponse;
    }

    @Override
    public TableOfficialDTO updateTableOfficial(Long id, TableOfficialRequest tableOfficialRequest) {
        TableOfficialEntity tableOfficialEntity = getById(id);
        tableOfficialMapper.update(tableOfficialEntity, tableOfficialRequest);
        return tableOfficialMapper.toDTO(tableOfficialRepository.save(tableOfficialEntity));
    }

    @Override
    public void deleteTableOfficial(Long id) {
        tableOfficialRepository.delete(getById(id));
    }

    private TableOfficialEntity getById(Long id) {
        return tableOfficialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Table Official with id " + id + " not found"));
    }
}
