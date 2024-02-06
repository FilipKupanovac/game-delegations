package com.kupi.service.mapper;

import com.kupi.persistence.entity.CompetitionEntity;
import com.kupi.rest.api.request.CompetitionRequest;
import com.kupi.rest.dto.CompetitionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CompetitionMapper {

    CompetitionEntity toEntity(CompetitionRequest competitionRequest);

    CompetitionDTO toDTO(CompetitionEntity competitionEntity);

    void update(@MappingTarget CompetitionEntity competitionEntity, CompetitionRequest competitionRequest);
}

