package com.kupi.delegations.service.mapper;

import com.kupi.delegations.persistence.entity.TableOfficialEntity;
import com.kupi.delegations.rest.api.request.TableOfficialRequest;
import com.kupi.delegations.rest.dto.TableOfficialDTO;
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

