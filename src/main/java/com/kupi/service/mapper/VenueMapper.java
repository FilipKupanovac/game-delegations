/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.service.mapper;

import com.kupi.persistence.entity.VenueEntity;
import com.kupi.rest.dto.VenueDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VenueMapper {

    @Mapping(target = "id", ignore = true)
    VenueEntity toEntity(VenueDTO venueDTO);

    VenueDTO toDTO(VenueEntity venueEntity);
}
