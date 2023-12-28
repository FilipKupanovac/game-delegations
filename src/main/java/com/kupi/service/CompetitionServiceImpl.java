package com.kupi.service;

import com.kupi.persistence.entity.CompetitionEntity;
import com.kupi.persistence.repository.CompetitionRepository;
import com.kupi.rest.dto.CompetitionDTO;
import com.kupi.service.mapper.CompetitionMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.List;

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
    public CompetitionDTO saveCompetition(CompetitionDTO competitionDTO) {
        CompetitionEntity competitionEntity = competitionMapper.toEntity(competitionDTO);
        competitionEntity.setUuid(idGenerator.generateId().toString());
        return competitionMapper.toDTO(competitionRepository.save(competitionEntity));
    }

    @Override
    public CompetitionDTO getCompetitionById(Long id) {
        return competitionMapper.toDTO(getById(id));
    }

    @Override
    public List<CompetitionDTO> getAllCompetitions() {
        // TODO - change to paging return with filters
        return competitionRepository.findAll().stream().map(competitionMapper::toDTO).toList();
    }

    @Override
    public CompetitionDTO updateCompetition(Long id, CompetitionDTO competitionDTO) {
        CompetitionEntity competitionEntity = getById(id);
        competitionMapper.update(competitionEntity, competitionDTO);
        return competitionMapper.toDTO(competitionRepository.save(competitionEntity));
    }

    @Override
    public void deleteCompetition(Long id) {
        competitionRepository.delete(getById(id));
    }

    private CompetitionEntity getById(Long id) {
        return competitionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Competition with id " + id + " not found"));
    }
}
