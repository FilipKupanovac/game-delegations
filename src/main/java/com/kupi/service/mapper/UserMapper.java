package com.kupi.service.mapper;

import com.kupi.persistence.entity.UserEntity;
import com.kupi.rest.api.request.UserRequest;
import com.kupi.rest.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    UserEntity toEntity(UserRequest userRequest);

    UserDTO toDTO(UserEntity userEntity);
}
