package com.kupi.rest.api.base;

import com.kupi.persistence.type.AcceptanceStatus;
import com.kupi.persistence.type.TableOfficialPosition;
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
