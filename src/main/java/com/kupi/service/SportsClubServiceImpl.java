package com.kupi.service;

import com.kupi.persistence.entity.SportsClubEntity;
import com.kupi.persistence.repository.SportsClubRepository;
import com.kupi.rest.dto.SportsClubDTO;
import com.kupi.service.mapper.SportsClubMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.List;

@Service
public class SportsClubServiceImpl implements SportsClubService {

    private final SportsClubRepository sportsClubRepository;
    private final SportsClubMapper sportsClubMapper;
    private final IdGenerator idGenerator;

    public SportsClubServiceImpl(SportsClubRepository sportsClubRepository, SportsClubMapper sportsClubMapper, IdGenerator idGenerator) {
        this.sportsClubRepository = sportsClubRepository;
        this.sportsClubMapper = sportsClubMapper;
        this.idGenerator = idGenerator;
    }

    @Override
    public SportsClubDTO saveSportsClub(SportsClubDTO sportsClubDTO) {
        SportsClubEntity sportsClubEntity = sportsClubMapper.toEntity(sportsClubDTO);
        sportsClubEntity.setUuid(idGenerator.generateId().toString());
        return sportsClubMapper.toDTO(sportsClubRepository.save(sportsClubEntity));
    }

    @Override
    public SportsClubDTO getSportsClubById(Long id) {
        return sportsClubMapper.toDTO(getById(id));
    }

    @Override
    public List<SportsClubDTO> getAllSportsClubs() {
        // TODO - change to paging return with filters
        return sportsClubRepository.findAll().stream().map(sportsClubMapper::toDTO).toList();
    }

    @Override
    public SportsClubDTO updateSportsClub(Long id, SportsClubDTO sportsClubDTO) {
        SportsClubEntity sportsClubEntity = getById(id);
        sportsClubMapper.update(sportsClubEntity, sportsClubDTO);
        return sportsClubMapper.toDTO(sportsClubRepository.save(sportsClubEntity));
    }

    @Override
    public void deleteSportsClub(Long id) {
        sportsClubRepository.delete(getById(id));
    }

    private SportsClubEntity getById(Long id) {
        return sportsClubRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sports Club with id " + id + " not found"));
    }
}
