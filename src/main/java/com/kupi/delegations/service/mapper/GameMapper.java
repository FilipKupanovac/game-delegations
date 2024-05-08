package com.kupi.delegations.service.mapper;

import com.kupi.delegations.persistence.entity.GameEntity;
import com.kupi.delegations.rest.api.request.GameRequest;
import com.kupi.delegations.rest.dto.GameDTO;
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
    GameEntity toEntity(GameRequest gameRequest);

    GameDTO toDTO(GameEntity gameEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "competition", ignore = true)
    @Mapping(target = "venue", ignore = true)
    @Mapping(target = "host", ignore = true)
    @Mapping(target = "guest", ignore = true)
    void update(@MappingTarget GameEntity gameEntity, GameRequest gameRequest);
}
