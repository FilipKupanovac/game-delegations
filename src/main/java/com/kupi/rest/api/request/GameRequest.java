package com.kupi.rest.api.request;

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
public class GameRequest extends BaseGame {

    private String competitionId;

    private String venueId;

    private String hostId;

    private String guestId;

    private String tableOfficialScorerId;

    private String tableOfficialTimeId;

    private String tableOfficialShotClockOperatorId;

    private String tableOfficialStatisticianId;

    private String tableOfficialStatisticianAssistantId;
}
