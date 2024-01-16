package com.kupi.rest.dto;

import com.kupi.rest.api.base.BaseGame;

public class GameDTO extends BaseGame {

    private VenueDTO venue;

    private SportClubDTO host;

    private SportClubDTO guest;

    private TableOfficialDTO scorer;

    private TableOfficialDTO timer;

    private TableOfficialDTO shotClockOperator;

    private TableOfficialDTO statistician;

    private TableOfficialDTO statisticianAssistant;
}
