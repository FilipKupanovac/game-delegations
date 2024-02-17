package com.kupi.rest.api.base;

import com.kupi.persistence.type.TableOfficialPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseAssignment {
    private Boolean accepted;

    private TableOfficialPosition position;
}
