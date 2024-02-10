package com.kupi.rest.dto;

import com.kupi.rest.api.base.BaseSportClub;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class SportClubDTO extends BaseSportClub {
}
