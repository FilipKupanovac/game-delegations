package com.kupi.service.mapper;

import com.kupi.persistence.entity.SportClubEntity;
import com.kupi.rest.dto.SportClubDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface SportClubMapper {

    @Mapping(target = "id", ignore = true)
    SportClubEntity toEntity(SportClubDTO sportClubDTO);

    SportClubDTO toDTO(SportClubEntity sportClubEntity);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget SportClubEntity sportClubEntity, SportClubDTO sportClubDTO);
}

