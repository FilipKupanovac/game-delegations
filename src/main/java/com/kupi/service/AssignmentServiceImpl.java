package com.kupi.service;

import com.kupi.persistence.entity.AssignmentEntity;
import com.kupi.persistence.repository.AssignmentRepository;
import com.kupi.rest.api.request.AssignmentRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.AssignmentDTO;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.service.mapper.AssignmentMapper;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final AssignmentMapper assignmentMapper;
    private final IdGenerator idGenerator;

    public AssignmentServiceImpl(AssignmentRepository assignmentRepository, AssignmentMapper assignmentMapper, IdGenerator idGenerator) {
        this.assignmentRepository = assignmentRepository;
        this.assignmentMapper = assignmentMapper;
        this.idGenerator = idGenerator;
    }

    @Override
    public AssignmentDTO createAssignment(AssignmentRequest assignmentRequest) {
        AssignmentEntity assignmentEntity = assignmentMapper.toEntity(assignmentRequest);
        assignmentEntity.setUuid(idGenerator.generateId().toString());
        // todo - set acceptance status default value if database not do it
        return assignmentMapper.toDTO(assignmentRepository.save(assignmentEntity));
    }

    @Override
    public AssignmentDTO getAssignment(String uuid) {
        return assignmentMapper.toDTO(getByUuid(uuid));
    }

    @Override
    public PagedResponse<AssignmentDTO> getAssignments(BasicPageQueryParams params) {
        PageRequest pageRequest = PageRequest.of(
                params.getPage(),
                params.getSize(),
                Sort.Direction.fromOptionalString(params.getDirection()).orElse(Sort.Direction.ASC),
                StringUtils.isNotBlank(params.getColumn()) ? params.getColumn() : "key"
        );
        if (assignmentRepository.count() < 1) {
            return PagedResponse.fromPage(Page.empty());
        }
        Page<AssignmentEntity> pageSlice = assignmentRepository.findAll(pageRequest);
        Page<AssignmentDTO> pageSliceDTO = pageSlice.map(assignmentMapper::toDTO);
        PagedResponse<AssignmentDTO> pagedResponse = PagedResponse.fromPage(pageSliceDTO);

        if (params.getPage() > pagedResponse.getTotalPages()) {
            throw new RuntimeException("Page out of bounds!");
        }
        return pagedResponse;
    }

    @Override
    public AssignmentDTO updateAssignment(String uuid, AssignmentRequest assignmentRequest) {
        AssignmentEntity assignmentEntity = getByUuid(uuid);
        assignmentMapper.update(assignmentEntity, assignmentRequest);
        return assignmentMapper.toDTO(assignmentRepository.save(assignmentEntity));
    }

    @Override
    public void deleteAssignment(String uuid) {
        assignmentRepository.delete(getByUuid(uuid));
    }

    private AssignmentEntity getByUuid(String uuid) {
        return assignmentRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Assignment with UUID " + uuid + " not found"));
    }
}
