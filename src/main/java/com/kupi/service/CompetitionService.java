/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.service;

import com.kupi.rest.dto.CompetitionDTO;

import java.util.List;

public interface CompetitionService {

    CompetitionDTO saveCompetition(CompetitionDTO competitionDTO);

    CompetitionDTO getCompetitionById(Long id);

    List<CompetitionDTO> getAllCompetitions();

    CompetitionDTO updateCompetition(Long id, CompetitionDTO competitionDTO);

    void deleteCompetition(Long id);
}
