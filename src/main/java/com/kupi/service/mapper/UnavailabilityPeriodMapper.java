package com.kupi.service.mapper;

import com.kupi.persistence.entity.UnavailabilityPeriodEntity;
import com.kupi.rest.api.request.UnavailabilityPeriodRequest;
import com.kupi.rest.dto.UnavailabilityPeriodDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UnavailabilityPeriodMapper {
    UnavailabilityPeriodEntity toEntity(UnavailabilityPeriodRequest unavailabilityPeriodRequest);

    UnavailabilityPeriodDTO toDTO(UnavailabilityPeriodEntity unavailabilityPeriodEntity);

    void update(@MappingTarget UnavailabilityPeriodEntity periodEntity, UnavailabilityPeriodRequest periodRequest);
}
