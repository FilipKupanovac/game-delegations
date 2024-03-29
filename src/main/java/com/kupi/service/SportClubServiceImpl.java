package com.kupi.service;

import com.kupi.persistence.entity.SportClubEntity;
import com.kupi.persistence.repository.SportClubRepository;
import com.kupi.rest.api.request.SportClubRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.SportClubDTO;
import com.kupi.service.mapper.SportClubMapper;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

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
    public SportClubDTO createSportClub(SportClubRequest sportClubRequest) {
        SportClubEntity sportClubEntity = sportClubMapper.toEntity(sportClubRequest);
        sportClubEntity.setUuid(idGenerator.generateId().toString());
        return sportClubMapper.toDTO(sportClubRepository.save(sportClubEntity));
    }

    @Override
    public SportClubDTO getSportClub(String uuid) {
        return sportClubMapper.toDTO(getByUuid(uuid));
    }

    @Override
    public PagedResponse<SportClubDTO> getSportClubs(BasicPageQueryParams params) {
        PageRequest pageRequest = PageRequest.of(
                params.getPage(),
                params.getSize(),
                Sort.Direction.fromOptionalString(params.getDirection()).orElse(Sort.Direction.ASC),
                StringUtils.isNotBlank(params.getColumn()) ? params.getColumn() : "key"
        );
        if (sportClubRepository.count() < 1) {
            return PagedResponse.fromPage(Page.empty());
        }
        Page<SportClubEntity> pageSlice = sportClubRepository.findAll(pageRequest);
        Page<SportClubDTO> pageSliceDTO = pageSlice.map(sportClubMapper::toDTO);
        PagedResponse<SportClubDTO> pagedResponse = PagedResponse.fromPage(pageSliceDTO);

        if (params.getPage() > pagedResponse.getTotalPages()) {
            throw new RuntimeException("Page out of bounds!");
        }
        return pagedResponse;
    }

    @Override
    public SportClubDTO updateSportClub(String uuid, SportClubRequest sportClubRequest) {
        SportClubEntity sportClubEntity = getByUuid(uuid);
        sportClubMapper.update(sportClubEntity, sportClubRequest);
        return sportClubMapper.toDTO(sportClubRepository.save(sportClubEntity));
    }

    @Override
    public void deleteSportClub(String uuid) {
        sportClubRepository.delete(getByUuid(uuid));
    }

    private SportClubEntity getByUuid(String uuid) {
        return sportClubRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Sport Club with uuid " + uuid + " not found"));
    }
}
