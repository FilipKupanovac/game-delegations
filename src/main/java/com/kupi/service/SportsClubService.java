/*
 * Urheberrechtshinweis: Diese Software ist urheberrechtlich geschützt. Das Urheberrecht liegt bei
 * Research Industrial Systems Engineering (RISE) Forschungs-, Entwicklungs- und Großprojektberatung GmbH,
 * soweit nicht im Folgenden näher gekennzeichnet.
 */
package com.kupi.service;

import com.kupi.rest.dto.SportsClubDTO;

import java.util.List;

public interface SportsClubService {

    SportsClubDTO saveSportsClub(SportsClubDTO sportsClubDTO);

    SportsClubDTO getSportsClubById(Long id);

    List<SportsClubDTO> getAllSportsClubs();

    SportsClubDTO updateSportsClub(Long id, SportsClubDTO sportsClubDTO);

    void deleteSportsClub(Long id);
}
