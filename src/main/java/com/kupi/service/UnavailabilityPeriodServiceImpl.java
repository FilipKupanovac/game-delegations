package com.kupi.service;

import com.kupi.persistence.entity.UnavailabilityPeriodEntity;
import com.kupi.persistence.repository.UnavailabilityPeriodRepository;
import com.kupi.rest.api.request.UnavailabilityPeriodRequest;
import com.kupi.rest.api.response.PagedResponse;
import com.kupi.rest.dto.BasicPageQueryParams;
import com.kupi.rest.dto.UnavailabilityPeriodDTO;
import com.kupi.service.mapper.UnavailabilityPeriodMapper;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

@Service
public class UnavailabilityPeriodServiceImpl implements UnavailabilityPeriodService {
    private final UnavailabilityPeriodRepository unavailabilityPeriodRepository;
    private final UnavailabilityPeriodMapper unavailabilityPeriodMapper;
    private final IdGenerator idGenerator;

    public UnavailabilityPeriodServiceImpl(
            UnavailabilityPeriodRepository unavailabilityPeriodRepository,
            UnavailabilityPeriodMapper unavailabilityPeriodMapper,
            IdGenerator idGenerator
    ) {
        this.unavailabilityPeriodRepository = unavailabilityPeriodRepository;
        this.unavailabilityPeriodMapper = unavailabilityPeriodMapper;
        this.idGenerator = idGenerator;
    }

    // todo - through security enable only authors and admin to tamper data, e.g. on create do not ask for official data, but rather pick it from security
    @Override
    public UnavailabilityPeriodDTO createUnavailabilityPeriod(UnavailabilityPeriodRequest unavailabilityPeriodRequest) {
        UnavailabilityPeriodEntity unavailabilityPeriodEntity = unavailabilityPeriodMapper.toEntity(unavailabilityPeriodRequest);
        unavailabilityPeriodEntity.setUuid(idGenerator.generateId().toString());
        return unavailabilityPeriodMapper.toDTO(unavailabilityPeriodRepository.save(unavailabilityPeriodEntity));
    }

    @Override
    public UnavailabilityPeriodDTO getUnavailabilityPeriodByUuid(String uuid) {
        return unavailabilityPeriodMapper.toDTO(getByUuid(uuid));
    }

    @Override
    public PagedResponse<UnavailabilityPeriodDTO> getUnavailabilityPeriods(BasicPageQueryParams params) {
        PageRequest pageRequest = PageRequest.of(
                params.getPage(),
                params.getSize(),
                Sort.Direction.fromOptionalString(params.getDirection()).orElse(Sort.Direction.ASC),
                StringUtils.isNotBlank(params.getColumn()) ? params.getColumn() : "key"
        );
        if (unavailabilityPeriodRepository.count() < 1) {
            return PagedResponse.fromPage(Page.empty());
        }
        Page<UnavailabilityPeriodEntity> pageSlice = unavailabilityPeriodRepository.findAll(pageRequest);
        Page<UnavailabilityPeriodDTO> pageSliceDTO = pageSlice.map(unavailabilityPeriodMapper::toDTO);
        PagedResponse<UnavailabilityPeriodDTO> pagedResponse = PagedResponse.fromPage(pageSliceDTO);

        if (params.getPage() > pagedResponse.getTotalPages()) {
            throw new RuntimeException("Page out of bounds!");
        }
        return pagedResponse;
    }

    @Override
    public UnavailabilityPeriodDTO updateUnavailabilityPeriod(String uuid, UnavailabilityPeriodRequest unavailabilityPeriodRequest) {
        UnavailabilityPeriodEntity unavailabilityPeriodEntity = getByUuid(uuid);
        unavailabilityPeriodMapper.update(unavailabilityPeriodEntity, unavailabilityPeriodRequest);
        return unavailabilityPeriodMapper.toDTO(unavailabilityPeriodRepository.save(unavailabilityPeriodEntity));
    }

    @Override
    public void deleteUnavailabilityPeriod(String uuid) {
        unavailabilityPeriodRepository.delete(getByUuid(uuid));
    }

    private UnavailabilityPeriodEntity getByUuid(String uuid) {
        return unavailabilityPeriodRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Unavailability Period with UUID " + uuid + " not found"));
    }
}
