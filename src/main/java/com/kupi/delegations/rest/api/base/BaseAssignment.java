package com.kupi.delegations.rest.api.base;

import com.kupi.delegations.persistence.type.AcceptanceStatus;
import com.kupi.delegations.persistence.type.TableOfficialPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseAssignment {
    private AcceptanceStatus acceptanceStatus;

    private TableOfficialPosition position;
}
