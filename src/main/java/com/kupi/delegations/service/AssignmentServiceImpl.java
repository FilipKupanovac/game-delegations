package com.kupi.delegations.service;

import com.kupi.delegations.persistence.entity.AssignmentEntity;
import com.kupi.delegations.persistence.entity.GameEntity;
import com.kupi.delegations.persistence.entity.TableOfficialEntity;
import com.kupi.delegations.persistence.repository.AssignmentRepository;
import com.kupi.delegations.persistence.repository.GameRepository;
import com.kupi.delegations.persistence.repository.TableOfficialRepository;
import com.kupi.delegations.rest.api.request.AssignmentRequest;
import com.kupi.delegations.rest.api.response.PagedResponse;
import com.kupi.delegations.rest.dto.AssignmentDTO;
import com.kupi.delegations.rest.dto.BasicPageQueryParams;
import com.kupi.delegations.service.mapper.AssignmentMapper;
import com.kupi.delegations.service.security.UserDetailsImpl;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final AssignmentMapper assignmentMapper;
    private final GameRepository gameRepository;
    private final TableOfficialRepository tableOfficialRepository;
    private final IdGenerator idGenerator;

    public AssignmentServiceImpl(AssignmentRepository assignmentRepository, AssignmentMapper assignmentMapper, GameRepository gameRepository,
                                 TableOfficialRepository tableOfficialRepository, IdGenerator idGenerator) {
        this.assignmentRepository = assignmentRepository;
        this.assignmentMapper = assignmentMapper;
        this.gameRepository = gameRepository;
        this.tableOfficialRepository = tableOfficialRepository;
        this.idGenerator = idGenerator;
    }

    @Override
    public AssignmentDTO createAssignment(AssignmentRequest assignmentRequest) {
        AssignmentEntity assignmentEntity = assignmentMapper.toEntity(assignmentRequest);
        assignmentEntity.setUuid(idGenerator.generateId().toString());
        assignmentEntity.setGame(getGameByUuid(assignmentRequest.getGameUuid()));
        assignmentEntity.setTableOfficial(getTableOfficialByUuid(assignmentRequest.getTableOfficialUuid()));
        // todo - set acceptance status default value if database not do it
        return assignmentMapper.toDTO(assignmentRepository.save(assignmentEntity));
    }

    @Override
    public AssignmentDTO getAssignment(String uuid) {
        return assignmentMapper.toDTO(getByUuid(uuid));
    }

    @Override
    public PagedResponse<AssignmentDTO> getAssignments(BasicPageQueryParams params) {
        // todo - make admin only
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

    @Override
    public PagedResponse<AssignmentDTO> getUserAssignments(BasicPageQueryParams params) {
        PageRequest pageRequest = PageRequest.of(
                params.getPage(),
                params.getSize(),
                Sort.Direction.fromOptionalString(params.getDirection()).orElse(Sort.Direction.ASC),
                StringUtils.isNotBlank(params.getColumn()) ? params.getColumn() : "key"
        );
        if (assignmentRepository.count() < 1) {
            return PagedResponse.fromPage(Page.empty());
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Page<AssignmentEntity> pageSlice = assignmentRepository.findAllByTableOfficialUuid(userDetails.getUserId(), pageRequest);
        Page<AssignmentDTO> pageSliceDTO = pageSlice.map(assignmentMapper::toDTO);
        PagedResponse<AssignmentDTO> pagedResponse = PagedResponse.fromPage(pageSliceDTO);

        if (params.getPage() > pagedResponse.getTotalPages()) {
            throw new RuntimeException("Page out of bounds!");
        }
        return pagedResponse;
    }

    private AssignmentEntity getByUuid(String uuid) {
        return assignmentRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Assignment with UUID " + uuid + " not found"));
    }

    private GameEntity getGameByUuid(String gameUuid) {
        return gameRepository.findByUuid(gameUuid)
                .orElseThrow(() -> new EntityNotFoundException("Game with uuid " + gameUuid + " not found"));
    }

    private TableOfficialEntity getTableOfficialByUuid(String tableOfficialUuid) {
        return tableOfficialRepository.findByUuid(tableOfficialUuid)
                .orElseThrow(() -> new EntityNotFoundException("Table official with uuid " + tableOfficialUuid + " not found"));
    }
}