package com.kupi.service;

import com.kupi.persistence.entity.VenueEntity;
import com.kupi.persistence.repository.VenueRepository;
import com.kupi.rest.api.request.VenueRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.VenueDTO;
import com.kupi.service.mapper.VenueMapper;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

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
    public VenueDTO saveVenue(VenueRequest venueRequest) {
        VenueEntity venueEntity = venueMapper.toEntity(venueRequest);
        venueEntity.setUuid(idGenerator.generateId().toString());
        return venueMapper.toDTO(venueRepository.save(venueEntity));
    }

    @Override
    public VenueDTO getVenueById(Long id) {
        return venueMapper.toDTO(getById(id));
    }

    @Override
    public PagedResponse<VenueDTO> getAllVenues(BasicPageQueryParams params) {
        PageRequest pageRequest = PageRequest.of(
                params.getPage(),
                params.getSize(),
                Sort.Direction.fromOptionalString(params.getDirection()).orElse(Sort.Direction.ASC),
                StringUtils.isNotBlank(params.getColumn()) ? params.getColumn() : "key"
        );
        if (venueRepository.count() < 1) {
            return PagedResponse.fromPage(Page.empty());
        }
        Page<VenueEntity> pageSlice = venueRepository.findAll(pageRequest);
        Page<VenueDTO> pageSliceDTO = pageSlice.map(venueMapper::toDTO);
        PagedResponse<VenueDTO> pagedResponse = PagedResponse.fromPage(pageSliceDTO);

        if (params.getPage() > pagedResponse.getTotalPages()) {
            throw new RuntimeException("Page out of bounds!");
        }
        return pagedResponse;
    }

    @Override
    public VenueDTO updateVenue(Long id, VenueRequest venueRequest) {
        VenueEntity venueEntity = getById(id);
        venueMapper.update(venueEntity, venueRequest);
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
