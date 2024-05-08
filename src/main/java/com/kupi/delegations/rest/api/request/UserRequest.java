package com.kupi.delegations.rest.api.request;

import com.kupi.delegations.rest.api.base.BaseUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class UserRequest extends BaseUser {
    private String encryptedPassword;

    private List<String> userRoles;
}
