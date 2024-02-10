package com.kupi.service.mapper;

import com.kupi.persistence.entity.TableOfficialEntity;
import com.kupi.rest.api.request.TableOfficialRequest;
import com.kupi.rest.dto.TableOfficialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TableOfficialMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    TableOfficialEntity toEntity(TableOfficialRequest tableOfficialRequest);

    TableOfficialDTO toDTO(TableOfficialEntity tableOfficialEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    void update(@MappingTarget TableOfficialEntity tableOfficialEntity, TableOfficialRequest tableOfficialRequest);
}

