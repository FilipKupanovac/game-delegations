package com.kupi.delegations.rest.api.request;

import com.kupi.delegations.rest.api.base.BaseAssignment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class AssignmentRequest extends BaseAssignment {
    private String gameUuid;

    private String tableOfficialUuid;
}
