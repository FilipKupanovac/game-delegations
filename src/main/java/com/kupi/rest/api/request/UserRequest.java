package com.kupi.rest.api.request;

import com.kupi.rest.api.base.BaseUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class UserRequest extends BaseUser {
    private String encryptedPassword;
}
