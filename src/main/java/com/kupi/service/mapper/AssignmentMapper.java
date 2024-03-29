package com.kupi.service.mapper;

import com.kupi.persistence.entity.AssignmentEntity;
import com.kupi.rest.api.request.AssignmentRequest;
import com.kupi.rest.dto.AssignmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AssignmentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "tableOfficial", ignore = true)
    @Mapping(target = "game", ignore = true)
    AssignmentEntity toEntity(AssignmentRequest assignmentRequest);

    AssignmentDTO toDTO(AssignmentEntity assignmentEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "tableOfficial", ignore = true)
    @Mapping(target = "game", ignore = true)
    void update(@MappingTarget AssignmentEntity assignmentEntity, AssignmentRequest assignmentRequest);
}
