package com.kupi.service.mapper;

import com.kupi.persistence.entity.UnavailabilityPeriodEntity;
import com.kupi.rest.api.request.UnavailabilityPeriodRequest;
import com.kupi.rest.dto.UnavailabilityPeriodDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UnavailabilityPeriodMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "tableOfficial", ignore = true)
    UnavailabilityPeriodEntity toEntity(UnavailabilityPeriodRequest unavailabilityPeriodRequest);

    UnavailabilityPeriodDTO toDTO(UnavailabilityPeriodEntity unavailabilityPeriodEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "tableOfficial", ignore = true)
    void update(@MappingTarget UnavailabilityPeriodEntity periodEntity, UnavailabilityPeriodRequest periodRequest);
}
