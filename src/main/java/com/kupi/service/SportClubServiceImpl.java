package com.kupi.service;

import com.kupi.persistence.entity.SportClubEntity;
import com.kupi.persistence.repository.SportClubRepository;
import com.kupi.rest.dto.SportClubDTO;
import com.kupi.service.mapper.SportClubMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.List;

@Service
public class SportClubServiceImpl implements SportClubService {

    private final SportClubRepository sportClubRepository;
    private final SportClubMapper sportClubMapper;
    private final IdGenerator idGenerator;

    public SportClubServiceImpl(SportClubRepository sportClubRepository, SportClubMapper sportClubMapper, IdGenerator idGenerator) {
        this.sportClubRepository = sportClubRepository;
        this.sportClubMapper = sportClubMapper;
        this.idGenerator = idGenerator;
    }

    @Override
    public SportClubDTO saveSportClub(SportClubDTO sportClubDTO) {
        SportClubEntity sportClubEntity = sportClubMapper.toEntity(sportClubDTO);
        sportClubEntity.setUuid(idGenerator.generateId().toString());
        return sportClubMapper.toDTO(sportClubRepository.save(sportClubEntity));
    }

    @Override
    public SportClubDTO getSportClubById(Long id) {
        return sportClubMapper.toDTO(getById(id));
    }

    @Override
    public List<SportClubDTO> getAllSportClubs() {
        // TODO - change to paging return with filters
        return sportClubRepository.findAll().stream().map(sportClubMapper::toDTO).toList();
    }

    @Override
    public SportClubDTO updateSportClub(Long id, SportClubDTO sportClubDTO) {
        SportClubEntity sportClubEntity = getById(id);
        sportClubMapper.update(sportClubEntity, sportClubDTO);
        return sportClubMapper.toDTO(sportClubRepository.save(sportClubEntity));
    }

    @Override
    public void deleteSportClub(Long id) {
        sportClubRepository.delete(getById(id));
    }

    private SportClubEntity getById(Long id) {
        return sportClubRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sport Club with id " + id + " not found"));
    }
}
