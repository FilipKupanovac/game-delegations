package com.kupi.service.mapper;

import com.kupi.persistence.entity.SportClubEntity;
import com.kupi.rest.api.request.SportClubRequest;
import com.kupi.rest.dto.SportClubDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface SportClubMapper {

    SportClubEntity toEntity(SportClubRequest sportClubRequest);

    SportClubDTO toDTO(SportClubEntity sportClubEntity);

    void update(@MappingTarget SportClubEntity sportClubEntity, SportClubRequest sportClubRequest);
}

