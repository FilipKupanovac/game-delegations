package com.kupi.service.mapper;

import com.kupi.persistence.entity.GameEntity;
import com.kupi.rest.api.request.GameRequest;
import com.kupi.rest.dto.GameDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GameMapper {

    GameEntity toEntity(GameRequest gameRequest);

    GameDTO toDTO(GameEntity gameEntity);

    void update(@MappingTarget GameEntity gameEntity, GameRequest gameRequest);
}
