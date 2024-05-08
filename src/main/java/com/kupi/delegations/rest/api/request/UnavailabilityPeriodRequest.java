package com.kupi.delegations.rest.api.request;

import com.kupi.delegations.rest.api.base.BaseUnavailabilityPeriod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UnavailabilityPeriodRequest extends BaseUnavailabilityPeriod {

    // todo - this is just a temporary solution, id would be used from an user itself and its authentication claims
    @UUID(version = 4)
    @Size(max = 36)
    @NotBlank
    private String tableOfficialId;
}
