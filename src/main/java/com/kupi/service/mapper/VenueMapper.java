package com.kupi.service.mapper;

import com.kupi.persistence.entity.VenueEntity;
import com.kupi.rest.api.request.VenueRequest;
import com.kupi.rest.dto.VenueDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface VenueMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    VenueEntity toEntity(VenueRequest venueRequest);

    VenueDTO toDTO(VenueEntity venueEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    void update(@MappingTarget VenueEntity venueEntity, VenueRequest venueRequest);
}
