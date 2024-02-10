package com.kupi.service.mapper;

import com.kupi.persistence.entity.GameEntity;
import com.kupi.rest.api.request.GameRequest;
import com.kupi.rest.dto.GameDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface GameMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "competition", ignore = true)
    @Mapping(target = "venue", ignore = true)
    @Mapping(target = "host", ignore = true)
    @Mapping(target = "guest", ignore = true)
    @Mapping(target = "scorer", ignore = true)
    @Mapping(target = "timer", ignore = true)
    @Mapping(target = "shotClockOperator", ignore = true)
    @Mapping(target = "statistician", ignore = true)
    @Mapping(target = "statisticianAssistant", ignore = true)
    GameEntity toEntity(GameRequest gameRequest);

    GameDTO toDTO(GameEntity gameEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "competition", ignore = true)
    @Mapping(target = "venue", ignore = true)
    @Mapping(target = "host", ignore = true)
    @Mapping(target = "guest", ignore = true)
    @Mapping(target = "scorer", ignore = true)
    @Mapping(target = "timer", ignore = true)
    @Mapping(target = "shotClockOperator", ignore = true)
    @Mapping(target = "statistician", ignore = true)
    @Mapping(target = "statisticianAssistant", ignore = true)
    void update(@MappingTarget GameEntity gameEntity, GameRequest gameRequest);
}
