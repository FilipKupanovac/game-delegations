package com.kupi.service;

import com.kupi.persistence.entity.CompetitionEntity;
import com.kupi.persistence.repository.CompetitionRepository;
import com.kupi.rest.api.request.CompetitionRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.CompetitionDTO;
import com.kupi.service.mapper.CompetitionMapper;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final CompetitionMapper competitionMapper;
    private final IdGenerator idGenerator;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository, CompetitionMapper competitionMapper, IdGenerator idGenerator) {
        this.competitionRepository = competitionRepository;
        this.competitionMapper = competitionMapper;
        this.idGenerator = idGenerator;
    }

    @Override
    public CompetitionDTO createCompetition(CompetitionRequest competitionRequest) {
        CompetitionEntity competitionEntity = competitionMapper.toEntity(competitionRequest);
        competitionEntity.setUuid(idGenerator.generateId().toString());
        return competitionMapper.toDTO(competitionRepository.save(competitionEntity));
    }

    @Override
    public CompetitionDTO getCompetition(String uuid) {
        return competitionMapper.toDTO(getById(uuid));
    }

    @Override
    public PagedResponse<CompetitionDTO> getAllCompetitions(BasicPageQueryParams params) {
        PageRequest pageRequest = PageRequest.of(
                params.getPage(),
                params.getSize(),
                Sort.Direction.fromOptionalString(params.getDirection()).orElse(Sort.Direction.ASC),
                StringUtils.isNotBlank(params.getColumn()) ? params.getColumn() : "key"
        );
        if (competitionRepository.count() < 1) {
            return PagedResponse.fromPage(Page.empty());
        }
        Page<CompetitionEntity> pageSlice = competitionRepository.findAll(pageRequest);
        Page<CompetitionDTO> pageSliceDTO = pageSlice.map(competitionMapper::toDTO);
        PagedResponse<CompetitionDTO> pagedResponse = PagedResponse.fromPage(pageSliceDTO);

        if (params.getPage() > pagedResponse.getTotalPages()) {
            throw new RuntimeException("Page out of bounds!");
        }
        return pagedResponse;
    }

    @Override
    public CompetitionDTO updateCompetition(String uuid, CompetitionRequest competitionRequest) {
        CompetitionEntity competitionEntity = getById(uuid);
        competitionMapper.update(competitionEntity, competitionRequest);
        return competitionMapper.toDTO(competitionRepository.save(competitionEntity));
    }

    @Override
    public void deleteCompetition(String uuid) {
        competitionRepository.delete(getById(uuid));
    }

    private CompetitionEntity getById(String uuid) {
        return competitionRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Competition with id " + uuid + " not found"));
    }
}
