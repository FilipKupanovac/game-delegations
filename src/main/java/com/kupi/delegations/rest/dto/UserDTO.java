package com.kupi.delegations.rest.dto;

import com.kupi.delegations.rest.api.base.BaseUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseUser {
    private String uuid;
}
