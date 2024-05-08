package com.kupi.delegations.rest.dto;

import com.kupi.delegations.rest.api.base.BaseUnavailabilityPeriod;
import jakarta.validation.constraints.NotNull;
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
public class UnavailabilityPeriodDTO extends BaseUnavailabilityPeriod {

    @NotNull
    private TableOfficialDTO tableOfficial;
}
