package com.kupi.service.mapper;

import com.kupi.persistence.entity.GameEntity;
import com.kupi.rest.dto.GameDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface GameMapper {

    @Mapping(target = "id", ignore = true)
    GameEntity toEntity(GameDTO gameDTO);

    GameDTO toDTO(GameEntity gameEntity);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget GameEntity gameEntity, GameDTO gameDTO);
}
