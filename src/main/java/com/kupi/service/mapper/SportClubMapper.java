package com.kupi.service.mapper;

import com.kupi.persistence.entity.SportClubEntity;
import com.kupi.rest.api.request.SportClubRequest;
import com.kupi.rest.dto.SportClubDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SportClubMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    SportClubEntity toEntity(SportClubRequest sportClubRequest);

    SportClubDTO toDTO(SportClubEntity sportClubEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    void update(@MappingTarget SportClubEntity sportClubEntity, SportClubRequest sportClubRequest);
}

