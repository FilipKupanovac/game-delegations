package com.kupi.service.mapper;

import com.kupi.persistence.entity.VenueEntity;
import com.kupi.rest.dto.VenueDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface VenueMapper {

    @Mapping(target = "id", ignore = true)
    VenueEntity toEntity(VenueDTO venueDTO);

    VenueDTO toDTO(VenueEntity venueEntity);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget VenueEntity venueEntity, VenueDTO venueDTO);
}
