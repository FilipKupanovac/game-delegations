package com.kupi.rest.api.base;

import com.kupi.rest.dto.CompetitionDTO;

import java.time.Instant;

public abstract class BaseGame {

    private CompetitionDTO competition;

    private Instant startTime;

    private Integer gameNumber;
}
