package com.kupi.service.mapper;

import com.kupi.persistence.entity.TableOfficialEntity;
import com.kupi.rest.api.request.TableOfficialRequest;
import com.kupi.rest.dto.TableOfficialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface TableOfficialMapper {

    TableOfficialEntity toEntity(TableOfficialRequest tableOfficialRequest);

    TableOfficialDTO toDTO(TableOfficialEntity tableOfficialEntity);

    void update(@MappingTarget TableOfficialEntity tableOfficialEntity, TableOfficialRequest tableOfficialRequest);
}

