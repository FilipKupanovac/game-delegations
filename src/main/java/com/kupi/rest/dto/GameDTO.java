package com.kupi.rest.dto;

import com.kupi.rest.api.base.BaseGame;
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
public class GameDTO extends BaseGame {
    private CompetitionDTO competition;

    private VenueDTO venue;

    private SportClubDTO host;

    private SportClubDTO guest;

    private TableOfficialDTO scorer;

    private TableOfficialDTO timer;

    private TableOfficialDTO shotClockOperator;

    private TableOfficialDTO statistician;

    private TableOfficialDTO statisticianAssistant;
}
