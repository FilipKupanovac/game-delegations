/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.rest.api.request;

import com.kupi.rest.api.base.BaseGame;

public class GameRequest extends BaseGame {

    private String venueId;

    private String hostId;

    private String guestId;

    private String tableOfficialScorerId;

    private String tableOfficialTimeId;

    private String tableOfficialShotClockOperatorId;

    private String tableOfficialStatisticianId;

    private String tableOfficialStatisticianAssistantId;
}
