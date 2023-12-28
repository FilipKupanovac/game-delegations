package com.kupi.service;

import com.kupi.persistence.entity.TableOfficialEntity;
import com.kupi.persistence.repository.TableOfficialRepository;
import com.kupi.rest.dto.TableOfficialDTO;
import com.kupi.service.mapper.TableOfficialMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.List;

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
    public TableOfficialDTO saveTableOfficial(TableOfficialDTO tableOfficialDTO) {
        TableOfficialEntity tableOfficialEntity = tableOfficialMapper.toEntity(tableOfficialDTO);
        tableOfficialEntity.setUuid(idGenerator.generateId().toString());
        return tableOfficialMapper.toDTO(tableOfficialRepository.save(tableOfficialEntity));
    }

    @Override
    public TableOfficialDTO getTableOfficialById(Long id) {
        return tableOfficialMapper.toDTO(getById(id));
    }

    @Override
    public List<TableOfficialDTO> getAllTableOfficials() {
        // TODO - change to paging return with filters
        return tableOfficialRepository.findAll().stream().map(tableOfficialMapper::toDTO).toList();
    }

    @Override
    public TableOfficialDTO updateTableOfficial(Long id, TableOfficialDTO tableOfficialDTO) {
        TableOfficialEntity tableOfficialEntity = getById(id);
        tableOfficialMapper.update(tableOfficialEntity, tableOfficialDTO);
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
