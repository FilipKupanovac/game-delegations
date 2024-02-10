package com.kupi.service.mapper;

import com.kupi.persistence.entity.CompetitionEntity;
import com.kupi.rest.api.request.CompetitionRequest;
import com.kupi.rest.dto.CompetitionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CompetitionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    CompetitionEntity toEntity(CompetitionRequest competitionRequest);

    CompetitionDTO toDTO(CompetitionEntity competitionEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    void update(@MappingTarget CompetitionEntity competitionEntity, CompetitionRequest competitionRequest);
}

