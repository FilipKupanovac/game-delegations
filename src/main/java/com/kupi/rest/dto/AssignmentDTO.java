package com.kupi.rest.dto;

import com.kupi.rest.api.base.BaseAssignment;
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
public class AssignmentDTO extends BaseAssignment {
    private GameDTO game;

    private TableOfficialDTO tableOfficial;
}
