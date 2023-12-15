/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.service.mapper;

import com.kupi.persistence.entity.GameEntity;
import com.kupi.rest.dto.GameDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GameMapper {

    @Mapping(target = "id", ignore = true)
    GameEntity toEntity(GameDTO gameDTO);

    GameDTO toDTO(GameEntity gameEntity);
}
