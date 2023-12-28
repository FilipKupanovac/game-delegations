package com.kupi.service.mapper;

import com.kupi.persistence.entity.SportsClubEntity;
import com.kupi.rest.dto.SportsClubDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface SportsClubMapper {

    @Mapping(target = "id", ignore = true)
    SportsClubEntity toEntity(SportsClubDTO sportsClubDTO);

    SportsClubDTO toDTO(SportsClubEntity sportsClubEntity);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget SportsClubEntity sportsClubEntity, SportsClubDTO sportsClubDTO);
}

