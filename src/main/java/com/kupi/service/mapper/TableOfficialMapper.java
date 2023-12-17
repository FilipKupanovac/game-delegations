/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.service.mapper;

import com.kupi.persistence.entity.TableOfficialEntity;
import com.kupi.rest.dto.TableOfficialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface TableOfficialMapper {

    @Mapping(target = "id", ignore = true)
    TableOfficialEntity toEntity(TableOfficialDTO tableOfficialDTO);

    TableOfficialDTO toDTO(TableOfficialEntity tableOfficialEntity);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget TableOfficialEntity tableOfficialEntity, TableOfficialDTO tableOfficialDTO);
}

