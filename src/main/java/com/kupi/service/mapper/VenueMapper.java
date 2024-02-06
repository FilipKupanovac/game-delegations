package com.kupi.service.mapper;

import com.kupi.persistence.entity.VenueEntity;
import com.kupi.rest.api.request.VenueRequest;
import com.kupi.rest.dto.VenueDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VenueMapper {

    VenueEntity toEntity(VenueRequest venueRequest);

    VenueDTO toDTO(VenueEntity venueEntity);

    void update(@MappingTarget VenueEntity venueEntity, VenueRequest venueRequest);
}
