package com.kupi.delegations.rest.dto;

import com.kupi.delegations.rest.api.base.BaseCompetition;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class CompetitionDTO extends BaseCompetition {
}
