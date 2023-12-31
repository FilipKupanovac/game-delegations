package com.kupi.rest.dto;

import java.time.Instant;

public class GameDTO {

    private CompetitionDTO competition;

    private Instant startTime;

    private Integer gameNumber;

    private VenueDTO venue;

    private SportClubDTO host;

    private SportClubDTO guest;

    private TableOfficialDTO scorer;

    private TableOfficialDTO timer;

    private TableOfficialDTO shotClockOperator;

    private TableOfficialDTO statistician;

    private TableOfficialDTO statisticianAssistant;
}
