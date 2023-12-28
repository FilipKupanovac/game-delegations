package com.kupi.service;

import com.kupi.persistence.entity.VenueEntity;
import com.kupi.persistence.repository.VenueRepository;
import com.kupi.rest.dto.VenueDTO;
import com.kupi.service.mapper.VenueMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;
    private final VenueMapper venueMapper;
    private final IdGenerator idGenerator;

    public VenueServiceImpl(VenueRepository venueRepository, VenueMapper venueMapper, IdGenerator idGenerator) {
        this.venueRepository = venueRepository;
        this.venueMapper = venueMapper;
        this.idGenerator = idGenerator;
    }

    @Override
    public VenueDTO saveVenue(VenueDTO venueDTO) {
        VenueEntity venueEntity = venueMapper.toEntity(venueDTO);
        venueEntity.setUuid(idGenerator.generateId().toString());
        return venueMapper.toDTO(venueRepository.save(venueEntity));
    }

    @Override
    public VenueDTO getVenueById(Long id) {
        return venueMapper.toDTO(getById(id));
    }

    @Override
    public List<VenueDTO> getAllVenues() {
        // TODO - change to paging return with filters
        return venueRepository.findAll().stream().map(venueMapper::toDTO).toList();
    }

    @Override
    public VenueDTO updateVenue(Long id, VenueDTO venueDTO) {
        VenueEntity venueEntity = getById(id);
        venueMapper.update(venueEntity, venueDTO);
        return venueMapper.toDTO(venueRepository.save(venueEntity));
    }

    @Override
    public void deleteVenue(Long id) {
        venueRepository.delete(getById(id));
    }

    private VenueEntity getById(Long id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Venue with id " + id + " not found"));
    }
}
