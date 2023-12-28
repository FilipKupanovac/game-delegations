package com.kupi.service.mapper;

import com.kupi.persistence.entity.CompetitionEntity;
import com.kupi.rest.dto.CompetitionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface CompetitionMapper {

    @Mapping(target = "id", ignore = true)
    CompetitionEntity toEntity(CompetitionDTO competitionDTO);

    CompetitionDTO toDTO(CompetitionEntity competitionEntity);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget CompetitionEntity competitionEntity, CompetitionDTO competitionDTO);
}

